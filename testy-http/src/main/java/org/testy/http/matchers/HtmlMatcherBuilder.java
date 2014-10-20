package org.testy.http.matchers;

import com.gargoylesoftware.htmlunit.StringWebResponse;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HTMLParser;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.hamcrest.*;
import org.testy.http.TestyHttpResponse;
import org.testy.matchers.AbstractMatcherBuilder;

import java.io.IOException;
import java.util.List;

public class HtmlMatcherBuilder<M extends HtmlMatcherBuilder> extends AbstractMatcherBuilder<M, TestyHttpResponse> {
    private final WebClient client = new WebClient();

    public M withElement (final ElementSelector selector) {
        return with(page(new TypeSafeMatcher<HtmlPage>() {
            @Override
            protected boolean matchesSafely(HtmlPage page) {
                return selector.select(page) != null;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("has element ").appendDescriptionOf(selector);
            }
        }));
    }

    public M withElement (final ElementSelector selector, Matcher<? super DomElement> elementMatcher) {
        return with(page(new FeatureMatcher<HtmlPage, DomElement>(elementMatcher, "", "") {
            @Override
            protected DomElement featureValueOf(HtmlPage page) {
                return selector.select(page);
            }
        }));
    }

    private FeatureMatcher<TestyHttpResponse, HtmlPage> page(Matcher<? super HtmlPage> pageMatcher) {
        return new FeatureMatcher<TestyHttpResponse, HtmlPage>(pageMatcher, "page", "HTML Page") {
            @Override
            protected HtmlPage featureValueOf(TestyHttpResponse input) {
                StringWebResponse response = new StringWebResponse(input.content(), input.uri());
                try {
                    return HTMLParser.parseHtml(response, client.getCurrentWindow());
                } catch (IOException e) {
                    throw new RuntimeException("Unable to parse the html", e);
                }
            }
        };
    }

    public interface ElementSelector extends SelfDescribing {
        DomElement select(HtmlPage page);
    }

    public static ElementSelector firstWithName (final String name) {
        return new ElementSelector() {
            @Override
            public DomElement select(HtmlPage page) {
                List<DomElement> elementsByName = page.getElementsByName(name);
                if (elementsByName.isEmpty()) return null;
                return elementsByName.get(0);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("by name ").appendValue(name);
            }
        };
    }

    public static ElementSelector id (final String id) {
        return new ElementSelector() {
            @Override
            public DomElement select(HtmlPage page) {
                return page.getElementById(id);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("by id ").appendValue(id);
            }
        };
    }
}
