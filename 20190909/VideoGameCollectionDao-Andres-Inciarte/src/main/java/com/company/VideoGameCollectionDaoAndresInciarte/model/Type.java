package com.company.VideoGameCollectionDaoAndresInciarte.model;

import java.util.Objects;

public class Type {
    private int typeId;
    private String name;
    private String description;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return typeId == type.typeId &&
                name.equals(type.name) &&
                description.equals(type.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, name, description);
    }
}
