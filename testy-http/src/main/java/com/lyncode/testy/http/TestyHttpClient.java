package com.lyncode.testy.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.hamcrest.Matcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class TestyHttpClient {
    private HttpClient client = HttpClients.createDefault();
    private String baseURL;
    private List<TestyHttpResponse> responses = new ArrayList<>();

    public TestyHttpClient(String baseURL) {
        this.baseURL = baseURL;
    }

    public TestyHttpClient receives (TestyHttpRequestBuilder request) {
        try {
            responses.add(new TestyHttpResponse(client.execute(request.build(baseURL))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public TestyHttpResponse sends () {
        if (responses.isEmpty()) return null;
        else return responses.get(responses.size() - 1);
    }

    public boolean sends (Matcher<? super HttpResponse> matcher) {
        return hasItem(matcher).matches(responses);
    }
}
