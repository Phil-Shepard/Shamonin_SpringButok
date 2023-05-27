package ru.Shamonin.web_Aircraft.Aircrafts.models.Engines;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.Shamonin.web_Aircraft.Aircrafts.validation.ValidateAircraftNumber;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElectricEngine {
    private String name;
    @Min(100)
    @Max(10000000)
    private int volume;
    private int id;
}
