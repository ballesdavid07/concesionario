package com.ms_concesionario.ms_concesionario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "car")
@Builder
public class Car {
    @Id
    private String id;
    @Column
    private String model;
    @Column
    private String color;
    @Column
    private Double price;
    @Column
    private int stock;
}
