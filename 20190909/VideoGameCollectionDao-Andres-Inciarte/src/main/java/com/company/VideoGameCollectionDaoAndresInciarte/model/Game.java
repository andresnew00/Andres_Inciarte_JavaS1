package com.company.VideoGameCollectionDaoAndresInciarte.model;

import java.util.Objects;

public class Game {
    private int consoleId;
    private String name;
    private String year;

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return consoleId == game.consoleId &&
                name.equals(game.name) &&
                year.equals(game.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consoleId, name, year);
    }
}
