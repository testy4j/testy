package com.lyncode.testy.http.matchers;

import com.lyncode.testy.matchers.AbstractMatcherBuilder;
import org.apache.http.Header;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

public class HttpHeaderMatcherBuilder extends AbstractMatcherBuilder<HttpHeaderMatcherBuilder, Header> {

    public HttpHeaderMatcherBuilder withName(Matcher<String> matcher) {
        return with(new FeatureMatcher<Header, String>(matcher, "name", "Header name") {
            @Override
            protected String featureValueOf(Header header) {
                return header.getName();
            }
        });
    }


    public HttpHeaderMatcherBuilder withValue(Matcher<String> matcher) {
        return with(new FeatureMatcher<Header, String>(matcher, "value", "Header value") {
            @Override
            protected String featureValueOf(Header header) {
                return header.getValue();
            }
        });
    }
}
