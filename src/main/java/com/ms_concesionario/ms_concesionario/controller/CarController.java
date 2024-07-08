package com.ms_concesionario.ms_concesionario.controller;

import com.ms_concesionario.ms_concesionario.dto.CarDto;
import com.ms_concesionario.ms_concesionario.service.ICarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/conc")
public class CarController {

    private final ICarService carService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.carService.getAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        return ResponseEntity.ok(this.carService.getById(id));
    }

    @GetMapping("/findByModel/{model}")
    public ResponseEntity<?> getByModel(@PathVariable String model){
        return ResponseEntity.ok(this.carService.getByModel(model));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CarDto carDto){
        return ResponseEntity.ok(this.carService.save(carDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid CarDto carDto, @PathVariable String id){
        return ResponseEntity.ok(this.carService.update(carDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        this.carService.delete(id);
        return ResponseEntity.accepted().body("Carro eliminado.");
    }
}
