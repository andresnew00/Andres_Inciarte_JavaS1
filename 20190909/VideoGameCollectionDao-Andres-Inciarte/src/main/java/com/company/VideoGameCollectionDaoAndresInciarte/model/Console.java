package com.company.VideoGameCollectionDaoAndresInciarte.model;

import java.util.Objects;

public class Console {
    private int gameId;
    private int consoleId;
    private int publisherId;
    private int typeId;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return gameId == console.gameId &&
                consoleId == console.consoleId &&
                publisherId == console.publisherId &&
                typeId == console.typeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, consoleId, publisherId, typeId);
    }
}
