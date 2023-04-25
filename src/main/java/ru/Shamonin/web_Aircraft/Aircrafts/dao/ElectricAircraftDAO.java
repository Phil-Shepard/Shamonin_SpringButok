package ru.Shamonin.web_Aircraft.Aircrafts.dao;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.Shamonin.web_Aircraft.Aircrafts.exceptions.DaoException;
import ru.Shamonin.web_Aircraft.Aircrafts.models.Vehicles.ElectricAircraft;
import ru.Shamonin.web_Aircraft.Aircrafts.models.Engines.ElectricEngine;


import java.util.ArrayList;
import java.util.List;

public class ElectricAircraftDAO {
    private List<ElectricAircraft> electricAircrafts = new ArrayList<>();
    private int id = 0;

    public List<ElectricAircraft> getAircrafts() {
        return electricAircrafts;
    }

    public ElectricAircraft getAircraftByEngineId(int id) {
        return electricAircrafts.stream().
                filter(electricAircraft-> electricAircraft.getEngine().getId() == id).
                findAny().
                orElseThrow(() -> new DaoException("Самолёт с таким id не найден."));
    }

    public synchronized ElectricAircraft addAircraft(ElectricAircraft electricAircraft) {
        ElectricEngine electricEngine = electricAircraft.getEngine();
        electricEngine.setId(++id);
        electricAircrafts.add(electricAircraft);
        return electricAircraft;
    }
}
