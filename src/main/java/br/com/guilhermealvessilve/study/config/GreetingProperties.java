package br.com.guilhermealvessilve.study.config;

import io.quarkus.arc.config.ConfigProperties;

import java.util.Optional;

@ConfigProperties(prefix = "greeting")
public class GreetingProperties {

    private String name;

    private String prefix;

    private Optional<String> suffix;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Optional<String> getSuffix() {
        return suffix;
    }

    public void setSuffix(Optional<String> suffix) {
        this.suffix = suffix;
    }
}
