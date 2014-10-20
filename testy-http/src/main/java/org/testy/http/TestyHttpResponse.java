package org.testy.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class TestyHttpResponse {
    private final String content;
    private HttpResponse response;
    private URL uri;

    public TestyHttpResponse(HttpResponse response, URL uri) {
        this.response = response;
        this.uri = uri;
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

    public URL uri() {
        return uri;
    }
}
