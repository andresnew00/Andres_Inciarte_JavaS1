package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.TShirt;

import java.util.List;

public interface TshirtDao {

    // CRUD

    /**
     * add a new tshirt to the db
     * @param tShirt
     * @return
     */
    TShirt addTshirt(TShirt tShirt);

    /**
     * get a tshirt by number
     * @param tShirtId
     * @return
     */
    TShirt getTshirt(int tShirtId);

    /**
     * get all shirts in the database
     * @return
     */
    List<TShirt> getAllTshirts();

    /**
     * update a shirt in the database
     * @param tShirt
     */
    void updateTshirt(TShirt tShirt);

    /**
     * delete a shirt from the database
     * @param tShirtId
     */
    void deleteTshirt(int tShirtId);

    // Find by color

    /**
     * get all shirts of the same color
     * @param color
     * @return
     */
    List<TShirt> getTshirtsByColor(String color);

    // Find by size

    /**
     * get all shirts of the same size
     * @param size
     * @return
     */
    List<TShirt> getTshirtsBySize(String size);
}
