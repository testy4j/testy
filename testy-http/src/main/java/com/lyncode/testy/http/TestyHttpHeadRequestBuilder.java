package com.lyncode.testy.http;

import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpRequestBase;

public class TestyHttpHeadRequestBuilder extends TestyHttpRequestBuilder<TestyHttpHeadRequestBuilder> {
    @Override
    protected HttpRequestBase build(String url) {
        return new HttpHead(url);
    }
}
