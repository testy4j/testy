package org.testy.http;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpRequestBase;

public class TestyHttpDeleteRequestBuilder extends TestyHttpRequestBuilder<TestyHttpDeleteRequestBuilder> {
    @Override
    protected HttpRequestBase build(String url) {
        return new HttpDelete(url);
    }
}
