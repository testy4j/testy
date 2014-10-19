package com.lyncode.testy;

import com.lyncode.testy.http.*;
import com.lyncode.testy.http.matchers.HttpHeaderMatcherBuilder;
import com.lyncode.testy.http.matchers.HttpResponseMatcherBuilder;

public class TestyHttp {
    // HTTP
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

    public static StringBodyContentBuilder content(String body) {
        return new StringBodyContentBuilder(body);
    }
    public static FormBodyContentBuilder form() {
        return new FormBodyContentBuilder();
    }

    public static TestyHttpClient server(String baseUrl) {
        return new TestyHttpClient(baseUrl);
    }

    // Matchers
    public static HttpResponseMatcherBuilder response () {
        return new HttpResponseMatcherBuilder();
    }
    public static HttpHeaderMatcherBuilder header () {
        return new HttpHeaderMatcherBuilder();
    }
}
