package com.company.CoffeeInventoryDaoAndresInciarte.dao;

import com.company.CoffeeInventoryDaoAndresInciarte.model.Coffee;

import java.util.List;

public interface CoffeeInventoryDao {

    /**
     * Create a new coffee
     * @param coffee
     * @return
     */
    Coffee createCoffee(Coffee coffee);

    /**
     * Return an existing coffee by id
     * @param coffeeId
     * @return
     */
    Coffee readCoffee(int coffeeId);

    /**
     * Return all coffee in a list
     * @return
     */
    List<Coffee> allCoffee();

    /**
     * update a coffee in a list
     * @param coffee
     */
    void updateCoffee(Coffee coffee);

    /**
     * delete a coffee in the list
     * @param coffeeId
     */
    void deleteCoffee(int coffeeId);

    /**
     * return a coffee by roaster id
     * @param roasterId
     * @return
     */
    List<Coffee> coffeeByRoaster(int roasterId);

    /**
     * return coffee by type
     * @param type
     * @return
     */
    List<Coffee> coffeeByType(String type);

}
