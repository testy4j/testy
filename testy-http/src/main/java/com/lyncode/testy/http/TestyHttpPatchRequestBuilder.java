package com.lyncode.testy.http;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPatch;

public class TestyHttpPatchRequestBuilder extends TestyHttpWithContentRequestBuilder<TestyHttpPatchRequestBuilder> {
    @Override
    HttpEntityEnclosingRequestBase buildEnclosable(String url) {
        return new HttpPatch(url);
    }
}
