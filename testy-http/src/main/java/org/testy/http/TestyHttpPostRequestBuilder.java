package org.testy.http;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;

public class TestyHttpPostRequestBuilder extends TestyHttpWithContentRequestBuilder<TestyHttpPostRequestBuilder> {
    @Override
    HttpEntityEnclosingRequestBase buildEnclosable(String url) {
        return new HttpPost(url);
    }
}
