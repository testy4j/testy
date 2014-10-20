package org.testy;

import org.testy.http.*;
import org.testy.http.matchers.HtmlMatcherBuilder;
import org.testy.http.matchers.HttpHeaderMatcherBuilder;
import org.testy.http.matchers.HttpResponseMatcherBuilder;
import org.testy.matchers.json.JsonMatcherBuilder;
import org.testy.matchers.xml.XmlMatcherBuilder;

public class Testy {
    // Matchers
    public static HttpResponseMatcherBuilder response () {
        return new HttpResponseMatcherBuilder();
    }
    public static HttpHeaderMatcherBuilder header () {
        return new HttpHeaderMatcherBuilder();
    }
    public StringBodyContentBuilder content(String body) {
        return new StringBodyContentBuilder(body);
    }
    public FormBodyContentBuilder form() {
        return new FormBodyContentBuilder();
    }
    public UrlBuilder path (String path) { return UrlBuilder.path(path); }

    public static JsonMatcherBuilder json () {
        return new JsonMatcherBuilder();
    }
    public static XmlMatcherBuilder xml () { return new XmlMatcherBuilder(); }
    public static HtmlMatcherBuilder html () { return new HtmlMatcherBuilder(); }

    public static TestyHttpGetRequestBuilder get() {
        return new TestyHttpGetRequestBuilder();
    }

    public static TestyHttpDeleteRequestBuilder delete() {
        return new TestyHttpDeleteRequestBuilder();
    }

    public static TestyHttpPostRequestBuilder post() {
        return new TestyHttpPostRequestBuilder();
    }

    public static TestyHttpPutRequestBuilder put() {
        return new TestyHttpPutRequestBuilder();
    }

    public static TestyHttpHeadRequestBuilder head() {
        return new TestyHttpHeadRequestBuilder();
    }

    public static TestyHttpOptionsRequestBuilder options() {
        return new TestyHttpOptionsRequestBuilder();
    }

    public static TestyHttpPatchRequestBuilder patch() {
        return new TestyHttpPatchRequestBuilder();
    }

    public static HeaderBuilder header(String name) {
        return new HeaderBuilder(name);
    }

    public static TestyHttpClient server(String baseUrl) {
        return new TestyHttpClient(baseUrl);
    }
}
