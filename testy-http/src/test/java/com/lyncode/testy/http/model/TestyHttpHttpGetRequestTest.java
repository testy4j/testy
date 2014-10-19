package com.lyncode.testy.http.model;

import com.lyncode.testy.http.TestyHttpClient;
import org.junit.Test;

import static com.lyncode.testy.TestyHttp.*;
import static com.lyncode.testy.http.UrlBuilder.path;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class TestyHttpHttpGetRequestTest {
    private TestyHttpClient google = server("http://www.google.com");


    @Test
    public void example() throws Exception {
        google.receives(get().to(path("/")));

        assertThat(google.sends(), response()
                .withStatusCode(equalTo(200))
        );
    }


}