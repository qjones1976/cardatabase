package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository <Car, Long> { 
    List<Car> findByBrand(String brand);
    
    List<Car> findByColor(String color);
 
    List<Car> findByYear(int year);

    List<Car> findByYearAndBrand(int year, String brand);
    
    List<Car> findByYearOrBrand(int year, String brand);
    
    @Query("select c from Car c where c.year >= ?1")
    List<Car> findNewCars(int year);
}