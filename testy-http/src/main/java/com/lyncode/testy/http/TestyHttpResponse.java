package com.lyncode.testy.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestyHttpResponse {
    private final String content;
    private HttpResponse response;

    public TestyHttpResponse(HttpResponse response) {
        this.response = response;
        try {
            this.content = IOUtils.toString(response.getEntity().getContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String content() {
        return content;
    }

    public int statusCode() {
        return response.getStatusLine().getStatusCode();
    }

    public List<Header> headers() {
        return Arrays.asList(response.getAllHeaders());
    }
}
