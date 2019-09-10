package com.company.AndresInciarteCarLotJpaRepository;

import com.company.AndresInciarteCarLotJpaRepository.Dao.CarRepository;
import com.company.AndresInciarteCarLotJpaRepository.Dto.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AndresInciarteCarLotJpaRepositoryApplicationTests {

	@Autowired
	CarRepository carRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createTest(){
		carRepository.deleteAll();

		Car car = new Car();
		car.setMake("Honda");
		car.setModel("Civic");
		car.setYear("2018");
		car.setColor("Black");

		car.setId(car.getId());

		carRepository.save(car);

		List<Car> carList = carRepository.findAll();
		assertEquals(1, carList.size());
	}

	@Test
	public void readTest() {

		carRepository.deleteAll();

		Car car = new Car();
		car.setMake("Honda");
		car.setModel("Civic");
		car.setYear("2018");
		car.setColor("Black");

		car.setId(car.getId());

		carRepository.save(car);

		carRepository.findById(car.getId());
	}

	@Test
	public void readAllTest() {
		carRepository.deleteAll();

		Car car = new Car();
		car.setMake("Honda");
		car.setModel("Civic");
		car.setYear("2018");
		car.setColor("Black");

		car.setId(car.getId());

		Car car2 = new Car();
		car2.setMake("Honda");
		car2.setModel("Civic");
		car2.setYear("2018");
		car2.setColor("Black");

		car2.setId(car.getId());


		carRepository.save(car);
		carRepository.save(car2);

		List<Car> carList = carRepository.findAll();
		assertEquals(2, carList.size());

	}

//	@Test
//	public void updateCarsTest() {
//		carRepository.deleteAll();
//
//		Car car = new Car();
//		car.setMake("Honda");
//		car.setModel("Civic");
//		car.setYear("2018");
//		car.setColor("Black");
//
//		car.setId(car.getId());
//
//		carRepository.save(car);
//

//		@Modifying
//		Car carUpdate = carRepository.findOne(car.getId());
//		carUpdate.setMake("Ford");
//		carUpdate.setModel("Fiesta");
//		carUpdate.setYear("2019");
//		carUpdate.setColor("Blue");
//
//		assertEquals(car, carUpdate);
//
//	}

//	@Test
//	public void deleteCar() {
//
//		Car car = new Car();
//		car.setMake("Honda");
//		car.setModel("Civic");
//		car.setYear("2018");
//		car.setColor("Black");
//
//		car.setId(car.getId());
//
//		carRepository.save(car);
//
//		carRepository.deleteCarById(car.getId());
//
//		assertNull(car);
//
//	}

}
