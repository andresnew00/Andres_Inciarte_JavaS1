package com.company.CarLotDaoAndresInciarte.dao;

import com.company.CarLotDaoAndresInciarte.model.Car;

import java.util.List;

public interface CarLotDao {
    /**
     * Reading one car with the given id
     * @param id
     * @return
     */
    Car getCar(int id);

    /**
     * Returns all cars
     * @return
     */
    List<Car> getAllCars();

    /**
     * Create a car and adds it to the database
     * @param car
     * @return
     */
    Car createCar(Car car);

    /**
     * Updates car with the matching id of the given car
     * @param car
     */
    void updateCar(Car car);

    /**
     * Delete a car from the database
     * @param id
     */
    void deleteCar(int id);

    /**
     * Get all the cars int the list by make
     * @param make
     * @return
     */
    List<Car> getCarsByMake(String make);

    /**
     * Get all the cars in the list by color
     * @param color
     * @return
     */
    List<Car> getCarsByColor(String color);
}
