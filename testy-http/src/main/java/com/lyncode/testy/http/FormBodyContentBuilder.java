package com.lyncode.testy.http;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class FormBodyContentBuilder extends BodyContentBuilder {
    private List<NameValuePair> valuePairs = new ArrayList<>();

    public FormValuePairBuilder withParameter(String name) {
        return new FormValuePairBuilder(name, this);
    }
    public FormBodyContentBuilder and() {
        return this;
    }

    @Override
    String build() {
        return null;
    }

    public static class FormValuePairBuilder {
        private final String name;
        private final FormBodyContentBuilder builder;

        public FormValuePairBuilder(String name, FormBodyContentBuilder builder) {
            this.name = name;
            this.builder = builder;
        }

        public FormBodyContentBuilder withValue (String value) {
            builder.valuePairs.add(new BasicNameValuePair(name, value));
            return builder;
        }
    }
}
