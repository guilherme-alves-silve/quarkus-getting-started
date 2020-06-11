package br.com.guilhermealvessilve.study.config;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

@ApplicationScoped
public class LifeCycleAppListener {

    private static final Logger LOGGER = Logger.getLogger(LifeCycleAppListener.class.getSimpleName());

    public void onStart(@Observes StartupEvent startupEvent) {
        LOGGER.info("onStart executed");
    }

    public void onShutdown(@Observes ShutdownEvent shutdownEvent) {
        LOGGER.info("onShutdown executed");
    }
}
