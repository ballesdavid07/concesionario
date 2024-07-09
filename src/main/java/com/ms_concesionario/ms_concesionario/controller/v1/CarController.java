package com.ms_concesionario.ms_concesionario.controller.v1;

import com.ms_concesionario.ms_concesionario.dto.CarDto;
import com.ms_concesionario.ms_concesionario.model.Car;
import com.ms_concesionario.ms_concesionario.service.ICarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarController implements CarDocV1{

    private final ICarService carService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Car>> getAll(){
        return ResponseEntity.ok(this.carService.getAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Car> getById(@PathVariable String id){
        return ResponseEntity.ok(this.carService.getById(id));
    }

    @GetMapping("/findByModel/{model}")
    public ResponseEntity<Car> getByModel(@PathVariable String model){
        return ResponseEntity.ok(this.carService.getByModel(model));
    }

    @PostMapping("/create")
    public ResponseEntity<Car> create(@RequestBody @Valid CarDto carDto){
        return ResponseEntity.ok(this.carService.save(carDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Car> update(@RequestBody @Valid CarDto carDto, @PathVariable String id){
        return ResponseEntity.ok(this.carService.update(carDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        this.carService.delete(id);
        return ResponseEntity.accepted().body("Carro eliminado.");
    }
}
