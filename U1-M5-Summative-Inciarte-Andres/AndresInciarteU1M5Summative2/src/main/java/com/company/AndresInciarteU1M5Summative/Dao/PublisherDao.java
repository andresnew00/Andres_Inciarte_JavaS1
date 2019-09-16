package com.company.AndresInciarteU1M5Summative.Dao;

import com.company.AndresInciarteU1M5Summative.Dto.Publisher;

import java.util.List;

public interface PublisherDao {

    /**
     * Create publisher
     * @param publisher
     * @return
     */
    Publisher createPublisher(Publisher publisher);

    /**
     * read a publisher by id
     * @param publisherId
     * @return
     */
    Publisher readPublisher(int publisherId);

    /**
     * read all publishers in db
     * @return
     */
    List<Publisher> readAllPublishers();

    /**
     * update a publisher in the db
     * @param publisher
     */
    void updatePublisher(Publisher publisher);

    /**
     * delete a publisher
     * @param publisherId
     */
    void deletePublisher(int publisherId);
}
