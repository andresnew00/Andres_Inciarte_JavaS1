package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.Console;

import java.util.List;

public interface ConsoleDao {

    //CRUD

    /**
     * create a new console instance in the db
     * @param console
     * @return
     */
    Console addConsole(Console console);

    /**
     * retrieve a console from the db by its id
     * @param consoleId
     * @return
     */
    Console getConsole(int consoleId);

    /**
     * get all the consoles currently in the db
     * @return
     */
    List<Console> getAllConsoles();

    /**
     * update a console in the db
     * @param console
     */
    void updateConsole(Console console);

    /**
     * delete a console from the db using its id
     * @param consoleId
     */
    void deleteConsole(int consoleId);

    //Search consoles by manufacturer

    /**
     * get all the consoles by the same manufacturer
     * @param manufacturer
     * @return
     */
    List<Console> getConsoleByManufacturer(String manufacturer);

}
