package com.company.AndresInciarteCoffeeInventoryJpaRepository;

import com.company.AndresInciarteCoffeeInventoryJpaRepository.Dao.CoffeeRepository;
import com.company.AndresInciarteCoffeeInventoryJpaRepository.Dto.Coffee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AndresInciarteCoffeeInventoryJpaRepositoryApplicationTests {


	@Autowired
	CoffeeRepository coffeeRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createTest(){
		coffeeRepository.deleteAll();

		Coffee coffee = new Coffee();
		coffee.setName("Expresso");
		coffee.setCount(20);
		coffee.setUnitPrice(21.2);
		coffee.setDescription("Very good coffee");
		coffee.setType("Dark");

		coffee.setCoffeeId(coffee.getCoffeeId());

		coffeeRepository.save(coffee);

		List<Coffee> carList = coffeeRepository.findAll();
		assertEquals(1, carList.size());
	}


}
