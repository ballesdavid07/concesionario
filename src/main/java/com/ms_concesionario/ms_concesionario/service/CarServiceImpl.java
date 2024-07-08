package com.ms_concesionario.ms_concesionario.service;

import com.ms_concesionario.ms_concesionario.dto.CarDto;
import com.ms_concesionario.ms_concesionario.exception.CarNotFoundException;
import com.ms_concesionario.ms_concesionario.model.Car;
import com.ms_concesionario.ms_concesionario.repository.ICarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarServiceImpl implements ICarService{

    private final ICarRepository carRepository;

    @Override
    public Car getById(String id) {
        return this.carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Carro no encontrado."));
    }

    @Override
    public Car getByModel(String model) {
        return this.carRepository.findByModel(model).orElseThrow(() -> new CarNotFoundException("Modelo no encontrado."));
    }

    @Override
    public List<Car> getAll() {
        return this.carRepository.findAll();
    }

    @Override
    public Car save(CarDto carDto) {
        Optional<Car> carFound = this.carRepository.findByModel(carDto.getModel());
        if (carFound.isPresent()) throw new CarNotFoundException("Este modelo ya existe.");
        String id = UUID.randomUUID().toString();
        Car car = Car.builder()
                .id(id)
                .model(carDto.getModel())
                .price(carDto.getPrice())
                .color(carDto.getColor())
                .stock(carDto.getStock())
                .build();
        return this.carRepository.save(car);
    }

    @Override
    public Car update(CarDto carDto, String id) {
        Car car = this.carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Carro no encontrado. "));
        car.setColor(carDto.getColor());
        car.setModel(carDto.getModel());
        car.setStock(carDto.getStock());
        car.setPrice(carDto.getPrice());
        return this.carRepository.save(car);
    }

    @Override
    public void delete(String id) {
        this.carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Este carro no existe."));
        this.carRepository.deleteById(id);
    }
}
