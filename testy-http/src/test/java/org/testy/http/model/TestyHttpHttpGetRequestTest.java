package org.testy.http.model;

import org.junit.Test;
import org.testy.http.TestyHttpClient;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.testy.TestyHttp.*;
import static org.testy.http.UrlBuilder.path;

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