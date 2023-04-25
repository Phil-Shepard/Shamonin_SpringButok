package ru.Shamonin.web_Aircraft.Vehicles;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.Shamonin.web_Aircraft.Engines.Engine;

@Component
@Slf4j
public class ElectricAircraft {
    private Engine engine;

    public ElectricAircraft(@Qualifier("electricEngine") Engine engine) {
        this.engine = engine;
    }

    @PostConstruct
    public void postConstruct(){
        log.info("Electric aircraft bean created.");
    }

    @PreDestroy
    public void preDestroy(){
        log.info("Electric aircraft bean deleted.");
    }
}
