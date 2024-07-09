package com.ms_concesionario.ms_concesionario.controller.v2;

import com.ms_concesionario.ms_concesionario.service.ICarService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CarControllerV2 implements CarDocV2{

    private final ICarService carService;

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.carService.getAll());
    }
}
