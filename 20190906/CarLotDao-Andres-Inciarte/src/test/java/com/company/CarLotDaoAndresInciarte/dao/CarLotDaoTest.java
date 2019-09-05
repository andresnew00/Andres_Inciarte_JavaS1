package com.company.CarLotDaoAndresInciarte.dao;

import com.company.CarLotDaoAndresInciarte.model.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarLotDaoTest {

    @Autowired
    protected CarLotDao dao;

    @Before
    public void setUp() throws Exception {
        List<Car> carList = dao.getAllCars();
        carList.forEach(car -> dao.deleteCar(car.getId()));
    }

    // try splitting when done
    @Test
    public void addGetDeleteCar() {
        Car car = new Car();

        car.setMake("Honda");
        car.setModel("Civic");
        car.setYear("2018");
        car.setColor("Blue");

        car = dao.createCar(car);

        Car car2 = dao.getCar(car.getId());

        assertEquals(car, car2);

        dao.deleteCar(car.getId());

        car2 = dao.getCar(car.getId());

        assertNull(car2);
    }

    @Test
    public void getAllCars() {
        Car car = new Car();

        car.setMake("Honda");
        car.setModel("Accord");
        car.setYear("2019");
        car.setColor("Blue");

        dao.createCar(car);

        car.setMake("Ford");
        car.setModel("Fiesta");
        car.setYear("2012");
        car.setColor("Black");

        dao.createCar(car);

        List<Car> allcars = dao.getAllCars();

        assertEquals(2,allcars.size());

    }

    @Test
    public void getCarByMake(){
        Car car = new Car();

        car.setMake("Honda");
        car.setModel("Accord");
        car.setYear("2019");
        car.setColor("Blue");

        dao.createCar(car);


        car.setMake("Honda");
        car.setModel("Civic");
        car.setYear("2019");
        car.setColor("Black");

        dao.createCar(car);


        car.setMake("Suzuki");
        car.setModel("Cool");
        car.setYear("2015");
        car.setColor("Brown");

        dao.createCar(car);

        List<Car> carList = dao.getCarsByMake("Honda");

        assertEquals(2,carList.size());
    }

    @Test
    public void getCarByColor(){
        Car car = new Car();

        car.setMake("Honda");
        car.setModel("Accord");
        car.setYear("2019");
        car.setColor("Blue");

        dao.createCar(car);


        car.setMake("Honda");
        car.setModel("Civic");
        car.setYear("2019");
        car.setColor("Black");

        dao.createCar(car);


        car.setMake("Suzuki");
        car.setModel("Cool");
        car.setYear("2015");
        car.setColor("Black");

        dao.createCar(car);

        List<Car> carList = dao.getCarsByColor("Black");

        assertEquals(2,carList.size());
    }

    @Test
    public void updateCar() {
        Car car = new Car();

        car.setMake("Honda");
        car.setModel("Africa Twin");
        car.setYear("2019");
        car.setColor("Black");

        car = dao.createCar(car);


        car.setMake("Honda");
        car.setModel("African Twin");
        car.setYear("2013");
        car.setColor("Black");

        dao.updateCar(car);

        Car car2 = dao.getCar(car.getId());

        assertEquals(car, car2);
    }

}