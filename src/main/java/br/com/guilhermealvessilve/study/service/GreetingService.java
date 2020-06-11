package br.com.guilhermealvessilve.study.service;

import br.com.guilhermealvessilve.study.config.Base64Value;
import br.com.guilhermealvessilve.study.config.GreetingProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class GreetingService {

    private static final Logger LOGGER = Logger.getLogger(GreetingService.class.getSimpleName());

    @ConfigProperty(name = "greeting.name")
    String greetingName;

    @ConfigProperty(name = "greeting.prefix", defaultValue = "")
    String greetingPrefix;

    @ConfigProperty(name = "greeting.suffix")
    Optional<String> greetingSuffix;

    @ConfigProperty(name = "greeting.base64name")
    Base64Value value;

    @Inject
    GreetingProperties properties;

    public String sayHello() {
        return "hello";
    }

    public String sayHello(String name) {
        LOGGER.debug("Saying hello to a random user");
        return String.format("Hello %s, your id is %s",
                name,
                UUID.randomUUID().toString()
        );
    }

    public String sayHelloUsingProperties() {
        return greetingPrefix + " " + greetingName + greetingSuffix.orElse("");
    }

    public String sayHelloUsingConverter() {
        return value.toString();
    }

    public String sayHelloUsingPropertiesObject() {
        return properties.getPrefix() + " " + properties.getName() + properties.getSuffix().orElse("");
    }
}
