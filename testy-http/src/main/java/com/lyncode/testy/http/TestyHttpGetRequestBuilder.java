package com.lyncode.testy.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;

public class TestyHttpGetRequestBuilder extends TestyHttpRequestBuilder<TestyHttpGetRequestBuilder> {
    @Override
    protected HttpRequestBase build(String url) {
        return new HttpGet(url);
    }
}
