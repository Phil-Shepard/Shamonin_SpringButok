package ru.Shamonin.web_Aircraft.Aircrafts.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.Shamonin.web_Aircraft.Aircrafts.dao.ElectricAircraftDAO;
import ru.Shamonin.web_Aircraft.Aircrafts.models.Vehicles.ElectricAircraft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aircrafts")
@RequiredArgsConstructor
public class AircraftController {
    private final ElectricAircraftDAO electricAircrafts;

    @GetMapping
    public List<ElectricAircraft> getAllAircrafts() {
        return electricAircrafts.getAircrafts();
    }

    @GetMapping("/{id}")
    public ElectricAircraft getAircraftByEngineId(@PathVariable int id) {
        return electricAircrafts.getAircraftByEngineId(id);
    }

    @GetMapping("/headers")
    public Map<String, String> getHeaders(@RequestHeader MultiValueMap<String, String> headers) {
        Map<String, String> map = new HashMap<>();

        headers.forEach((key, value) -> {
            map.put(key, String.join("|", value));
        });

        return map;
    }

    @PostMapping("/add")
    public ElectricAircraft addAircraftAndReturn(@RequestBody ElectricAircraft electricAircraft) {
        return electricAircrafts.addAircraft(electricAircraft);
    }
}
