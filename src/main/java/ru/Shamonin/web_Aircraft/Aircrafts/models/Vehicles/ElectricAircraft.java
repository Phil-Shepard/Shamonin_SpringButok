package ru.Shamonin.web_Aircraft.Aircrafts.models.Vehicles;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.Shamonin.web_Aircraft.Aircrafts.models.Engines.ElectricEngine;
import ru.Shamonin.web_Aircraft.Aircrafts.validation.ValidateAircraftNumber;
import ru.Shamonin.web_Aircraft.Aircrafts.validation.ValidateAircraftPrice;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectricAircraft {
    private ElectricEngine engine;
    @ValidateAircraftPrice
    private String price;
    @ValidateAircraftNumber
    private String number;
}
