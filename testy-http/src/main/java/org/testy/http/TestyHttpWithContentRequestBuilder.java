package org.testy.http;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;

public abstract class TestyHttpWithContentRequestBuilder<T extends TestyHttpWithContentRequestBuilder> extends TestyHttpRequestBuilder<T> {
    private String content;

    @Override
    protected HttpRequestBase build(String url) {
        HttpEntityEnclosingRequestBase requestBase = buildEnclosable(url);
        try {
            requestBase.setEntity(new StringEntity(content));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return requestBase;
    }

    abstract HttpEntityEnclosingRequestBase buildEnclosable (String url);

    public TestyHttpRequestBuilder with(BodyContentBuilder content) {
        this.content = content.build();
        return self();
    }
}
