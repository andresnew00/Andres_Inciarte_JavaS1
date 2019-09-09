package com.company.CoffeeInventoryDaoAndresInciarte.dao;

import com.company.CoffeeInventoryDaoAndresInciarte.model.Coffee;
import com.company.CoffeeInventoryDaoAndresInciarte.model.Roaster;

import java.util.List;

public interface RoasterDao {
    /**
     * Create a new roaster
     * @param roaster
     * @return
     */
    Roaster createRoaster(Roaster roaster);

    /**
     * Return an existing roaster by id
     * @param roasterId
     * @return
     */
    Roaster readRoaster(int roasterId);

    /**
     * Return all roaster in a list
     * @return
     */
    List<Roaster> allRoasters();

    /**
     * update a roaster in a list
     * @param roaster
     */
    void updateRoaster(Roaster roaster);

    /**
     * delete a roaster in the list
     * @param roasterId
     */
    void deleteRoaster(int roasterId);

}
