package br.com.guilhermealvessilve.study.config;

import java.util.Base64;

public class Base64Value {

    private final String value;

    public Base64Value(final String value) {
        this.value = new String(Base64.getDecoder().decode(value));
    }

    @Override
    public String toString() {
        return value;
    }
}
