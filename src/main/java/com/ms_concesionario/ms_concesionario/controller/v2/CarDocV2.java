package com.ms_concesionario.ms_concesionario.controller.v2;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Car", description = "Api expuesta para la administración de un Concesionario")
@RequestMapping("/api/v2/conc")
public interface CarDocV2 {

    @Operation(summary = "Obtener todos los vehículos existentes en el concesionario")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Respuesta",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping
    ResponseEntity<?> getAll();
}