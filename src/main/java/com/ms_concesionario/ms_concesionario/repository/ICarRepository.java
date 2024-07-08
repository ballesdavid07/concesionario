package com.ms_concesionario.ms_concesionario.repository;

import com.ms_concesionario.ms_concesionario.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICarRepository extends JpaRepository<Car, String> {
    Optional<Car> findByModel(String model);
}
