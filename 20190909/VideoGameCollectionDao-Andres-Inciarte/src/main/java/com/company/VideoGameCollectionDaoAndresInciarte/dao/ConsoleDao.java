package com.company.VideoGameCollectionDaoAndresInciarte.dao;

import com.company.VideoGameCollectionDaoAndresInciarte.model.Console;

import java.util.List;

public interface ConsoleDao {

    //* Your DAO API must allow callers to create, read,
    // read all, update, and delete Games, Consoles, Publishers,
    // and Types in the system. The system must also allow callers
    // to find Games by Console, Games by Publishers, and Games by Type.
    //* Your solution must be based on the database created by the SQL
    // script below.

    /**
     * Create a new console
     * @param console
     * @return
     */
    Console createConsole(Console console);

    /**
     * Get a new console
     * @param console_id
     * @return
     */
    Console readConsole(int console_id);

    /**
     * Retrun all
     * @return
     */
    List<Console> getallConsole();



}
