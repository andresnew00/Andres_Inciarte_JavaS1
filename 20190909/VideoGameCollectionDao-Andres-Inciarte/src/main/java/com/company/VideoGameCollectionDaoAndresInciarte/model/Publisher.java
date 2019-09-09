package com.company.VideoGameCollectionDaoAndresInciarte.model;

import java.util.Objects;

public class Publisher {
    private int publisherId;
    private String name;
    private String website;

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisherId == publisher.publisherId &&
                name.equals(publisher.name) &&
                Objects.equals(website, publisher.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId, name, website);
    }
}
