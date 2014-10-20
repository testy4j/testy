package org.testy.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
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
    private List<RequestInterceptor> requestInterceptors = new ArrayList<>();
    private List<ResponseInterceptor> responseInterceptors = new ArrayList<>();

    public TestyHttpClient(String baseURL) {
        this.baseURL = baseURL;
    }

    public TestyHttpClient receives (TestyHttpRequestBuilder request) {
        try {
            HttpRequestBase build = request.request(baseURL);
            for (RequestInterceptor requestInterceptor : requestInterceptors) {
                requestInterceptor.intercept(build);
            }
            HttpResponse response = client.execute(build);
            for (ResponseInterceptor responseInterceptor : responseInterceptors) {
                responseInterceptor.intercept(response);
            }
            responses.add(new TestyHttpResponse(response, build.getURI().toURL()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public TestyHttpResponse sends () {
        if (responses.isEmpty()) return null;
        else return responses.get(responses.size() - 1);
    }

    public TestyHttpClient interceptor (RequestInterceptor interceptor) {
        this.requestInterceptors.add(interceptor);
        return this;
    }

    public TestyHttpClient interceptor (ResponseInterceptor interceptor) {
        this.responseInterceptors.add(interceptor);
        return this;
    }

    public boolean sends (Matcher<? super HttpResponse> matcher) {
        return hasItem(matcher).matches(responses);
    }

    public interface RequestInterceptor {
        void intercept(HttpRequestBase request);
    }
    public interface ResponseInterceptor {
        void intercept(HttpResponse response);
    }
}
