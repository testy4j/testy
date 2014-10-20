package org.testy.http;

public class StringBodyContentBuilder extends BodyContentBuilder {
    private String body;

    public StringBodyContentBuilder(String body) {
        this.body = body;
    }

    @Override
    String build() {
        return body;
    }
}
