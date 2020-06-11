package br.com.guilhermealvessilve.study.resource;

import br.com.guilhermealvessilve.study.service.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.sayHello();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("id") String id) {
        return greetingService.sayHello(id);
    }

    @GET
    @Path("/properties")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloFromProperties() {
        return greetingService.sayHelloUsingProperties();
    }

    @GET
    @Path("/properties/file")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloFromPropertiesFile() {
        return greetingService.sayHelloUsingPropertiesObject();
    }

    @GET
    @Path("/properties/converter")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloPropertiesConverter() {
        return greetingService.sayHelloUsingConverter();
    }
}