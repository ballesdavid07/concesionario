package com.ms_concesionario.ms_concesionario.controller.v1;

import com.ms_concesionario.ms_concesionario.dto.CarDto;
import com.ms_concesionario.ms_concesionario.model.Car;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Car", description = "Api expuesta para la administración de un Concesionario primera versión")
@RequestMapping("/api/v1/conc")
public interface CarDocV1 {

    @Operation(summary = "Obtener todos los vehículos existentes en el concesionario.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Respuesta Exitosa",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))

    })
    @GetMapping("/getAll")
    public ResponseEntity<List<Car>> getAll();

    @Operation(summary = "Obtener un vehículo basado en su ID.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Respuesta Exitosa",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error en la consulta",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))

    })
    @GetMapping("/findById/{id}")
    public ResponseEntity<Car> getById(@PathVariable String id);

    @Operation(summary = "Obtener un vehículo basado en su modelo.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Respuesta Exitosa",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error en la consulta",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping("/findByModel/{model}")
    ResponseEntity<Car> getByModel(@PathVariable String model);

    @Operation(summary = "Guardar un nuevo vehículo en el concesionario.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Respuesta Exitosa",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error en la consulta",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PostMapping("/create")
    public ResponseEntity<Car> create(@RequestBody @Valid CarDto carDto);

    @Operation(summary = "Actualizar los datos de un vehículo")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Respuesta Exitosa",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error en la consulta",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> update(@RequestBody @Valid CarDto carDto, @PathVariable String id);

    @Operation(summary = "Eliminar un vehículo del concesionario")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "Respuesta",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error en la consulta",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id);
}
