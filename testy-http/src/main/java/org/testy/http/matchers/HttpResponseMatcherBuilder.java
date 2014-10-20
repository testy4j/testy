package org.testy.http.matchers;

import org.apache.http.Header;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.testy.http.TestyHttpResponse;
import org.testy.matchers.AbstractMatcherBuilder;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;

public class HttpResponseMatcherBuilder extends AbstractMatcherBuilder<HttpResponseMatcherBuilder, TestyHttpResponse> {
    public HttpResponseMatcherBuilder withContent(Matcher<String> matcher) {
        return with(new FeatureMatcher<TestyHttpResponse, String>(matcher, "body", "HTTP Body") {
            @Override
            protected String featureValueOf(TestyHttpResponse testyHttpResponse) {
                return testyHttpResponse.content();
            }
        });
    }

    public HttpResponseMatcherBuilder with(HtmlMatcherBuilder matcher) {
        return super.with(matcher);
    }

    public HttpResponseMatcherBuilder withStatusCode(Matcher<Integer> statusCodeMatcher) {
        return with(new FeatureMatcher<TestyHttpResponse, Integer>(statusCodeMatcher, "status code", "HTTP status") {
            @Override
            protected Integer featureValueOf(TestyHttpResponse testyHttpResponse) {
                return testyHttpResponse.statusCode();
            }
        });
    }

    public HttpResponseMatcherBuilder whereHeaders(Matcher<Iterable<? super Header>> matcher) {
        return with(new FeatureMatcher<TestyHttpResponse, Iterable<Header>>(matcher, "headers", "HTTP Headers") {
            @Override
            protected Iterable<Header> featureValueOf(TestyHttpResponse testyHttpResponse) {
                return testyHttpResponse.headers();
            }
        });
    }

    public HttpResponseMatcherBuilder withHeader(String name, Matcher<String> matcher) {
        return whereHeaders(hasItem(new HttpHeaderMatcherBuilder().withName(equalTo(name)).withValue(matcher)));
    }
}
