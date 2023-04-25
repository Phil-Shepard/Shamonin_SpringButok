package ru.Shamonin.web_Aircraft.Vehicles;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.Shamonin.web_Aircraft.Engines.Engine;

@Component
@Slf4j
public class GasolineAircraft {
    @Qualifier("gasolineEngine")
    private Engine engine;

    @PostConstruct
    public void postConstruct(){
        log.info("Gasoline aircraft bean created.");
    }

    @PreDestroy
    public void preDestroy(){
        log.info("Gasoline aircraft bean deleted.");
    }
}
