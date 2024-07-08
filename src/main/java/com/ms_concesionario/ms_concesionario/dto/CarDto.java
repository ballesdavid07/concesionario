package com.ms_concesionario.ms_concesionario.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDto {
    @NotEmpty
    private String model;

    @NotEmpty
    private String color;

    @NotNull
    private Double price;

    @NotNull
    private int stock;
}
