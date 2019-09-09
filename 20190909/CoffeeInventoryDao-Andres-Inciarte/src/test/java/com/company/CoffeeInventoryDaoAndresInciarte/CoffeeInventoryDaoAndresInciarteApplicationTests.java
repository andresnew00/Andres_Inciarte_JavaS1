package com.company.CoffeeInventoryDaoAndresInciarte;

import com.company.CoffeeInventoryDaoAndresInciarte.dao.CoffeeInventoryDao;
import com.company.CoffeeInventoryDaoAndresInciarte.model.Coffee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoffeeInventoryDaoAndresInciarteApplicationTests {

	@Autowired
	protected CoffeeInventoryDao dao;

	@Before
	public void setUp() throws Exception {
		// clean out the test db
		List<Coffee> cList = dao.allCoffee();

		cList.stream()
				.forEach(coffee -> dao.deleteCoffee(coffee.getCoffeeId()));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addGetDeleteCoffee() {

		Coffee coffee = new Coffee();
				coffee.setRoasterId(22);
				coffee.setName("Expresso");
				coffee.setCount(12);
				coffee.setUnitPrice(2);
				coffee.setDescription("great coffee");
				coffee.setType("dark");

		coffee = dao.createCoffee(coffee);

		Coffee coffee2 = dao.readCoffee(coffee.getCoffeeId());

		assertEquals(coffee, coffee2);

		dao.deleteCoffee(coffee.getCoffeeId());

		coffee2 = dao.readCoffee(coffee.getCoffeeId());

		assertNull(coffee2);
	}

	@Test
	public void getAllCoffee() {

		Coffee coffee = new Coffee();
		coffee.setRoasterId(44);
		coffee.setName("Crazy");
		coffee.setCount(13);
		coffee.setUnitPrice(22);
		coffee.setDescription("bad coffee");
		coffee.setType("light");

		dao.createCoffee(coffee);

		coffee.setRoasterId(2111);
		coffee.setName("Expresso");
		coffee.setCount(12);
		coffee.setUnitPrice(2);
		coffee.setDescription("great coffee");
		coffee.setType("dark");

		dao.createCoffee(coffee);

		List<Coffee> coffeeList = dao.allCoffee();

		assertEquals(coffeeList.size(), 2);
	}

	@Test
	public void getCoffeeByType() {

		Coffee coffee = new Coffee();
		coffee.setRoasterId(4422);
		coffee.setName("Crazy");
		coffee.setCount(13);
		coffee.setUnitPrice(22);
		coffee.setDescription("bad coffee");
		coffee.setType("light");

		dao.createCoffee(coffee);

		coffee.setRoasterId(213211);
		coffee.setName("Expresso");
		coffee.setCount(12);
		coffee.setUnitPrice(2);
		coffee.setDescription("great coffee");
		coffee.setType("dark");

		dao.createCoffee(coffee);

		coffee.setRoasterId(212211);
		coffee.setName("Expresso");
		coffee.setCount(12);
		coffee.setUnitPrice(2);
		coffee.setDescription("great coffee");
		coffee.setType("dark");

		dao.createCoffee(coffee);

		List<Coffee> mList = dao.coffeeByType("dark");
		assertEquals(mList.size(), 2);

		mList = dao.coffeeByType("light");
		assertEquals(mList.size(), 1);

	}

	@Test
	public void getCoffeeByRoaster() {

		Coffee coffee = new Coffee();
		coffee.setRoasterId(4422);
		coffee.setName("Crazy");
		coffee.setCount(13);
		coffee.setUnitPrice(22);
		coffee.setDescription("bad coffee");
		coffee.setType("light");

		dao.createCoffee(coffee);

		coffee.setRoasterId(213211);
		coffee.setName("Expresso");
		coffee.setCount(12);
		coffee.setUnitPrice(2);
		coffee.setDescription("great coffee");
		coffee.setType("dark");

		dao.createCoffee(coffee);

		coffee.setRoasterId(212211);
		coffee.setName("Expresso");
		coffee.setCount(12);
		coffee.setUnitPrice(2);
		coffee.setDescription("great coffee");
		coffee.setType("dark");

		dao.createCoffee(coffee);

		List<Coffee> mList = dao.coffeeByRoaster(212211);
		assertEquals(mList.size(), 1);

	}


	@Test
	public void updateCoffee() {

		Coffee coffee = new Coffee();
		coffee.setRoasterId(4422);
		coffee.setName("Crazy");
		coffee.setCount(13);
		coffee.setUnitPrice(22);
		coffee.setDescription("bad coffee");
		coffee.setType("light");

		dao.createCoffee(coffee);

		coffee.setRoasterId(213211);
		coffee.setName("Expresso");
		coffee.setCount(12);
		coffee.setUnitPrice(2);
		coffee.setDescription("great coffee");
		coffee.setType("dark");

		dao.createCoffee(coffee);

		Coffee coffee1 = dao.readCoffee(coffee.getCoffeeId());

		assertEquals(coffee1, coffee);
	}

}
