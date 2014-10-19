package com.lyncode.testy.http;

import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpRequestBase;

public class TestyHttpOptionsRequestBuilder extends TestyHttpRequestBuilder<TestyHttpOptionsRequestBuilder> {
    @Override
    protected HttpRequestBase build(String url) {
        return new HttpOptions(url);
    }
}
