package app.repository;

import app.entity.Car;


import java.util.List;


public class CarRepository {

    public List<Car> findByBrand(String brand){
        return List.of(
                new Car(1L, "bmw","1123"),
                new Car(2L, "bmw","1124")
        );
    }


}
