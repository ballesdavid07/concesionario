package com.ms_concesionario.ms_concesionario.service;

import com.ms_concesionario.ms_concesionario.dto.CarDto;
import com.ms_concesionario.ms_concesionario.model.Car;

import java.util.List;

public interface ICarService {
    Car getById(String id);
    Car getByModel(String model);
    List<Car> getAll();
    Car save(CarDto carDto);
    Car update(CarDto carDto, String id);
    void delete(String id);
}
