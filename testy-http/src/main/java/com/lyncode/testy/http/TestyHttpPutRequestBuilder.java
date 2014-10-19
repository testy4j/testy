package com.lyncode.testy.http;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPut;

public class TestyHttpPutRequestBuilder extends TestyHttpWithContentRequestBuilder<TestyHttpPutRequestBuilder> {
    @Override
    HttpEntityEnclosingRequestBase buildEnclosable(String url) {
        return new HttpPut(url);
    }
}
