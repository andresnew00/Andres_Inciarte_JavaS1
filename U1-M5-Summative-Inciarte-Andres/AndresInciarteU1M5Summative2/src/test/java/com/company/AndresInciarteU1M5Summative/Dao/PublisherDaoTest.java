package com.company.AndresInciarteU1M5Summative.Dao;

import com.company.AndresInciarteU1M5Summative.Dto.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherDaoTest {

    @Autowired
    private PublisherDao publisherDao;

    private Publisher publisher, publisher2;

    @Before
    public void setUp() throws Exception {
        publisherDao.readAllPublishers().forEach(publisher -> {
            publisherDao.deletePublisher(publisher.getPublisherId());
        });

        publisher = new Publisher();
        publisher.setName("Samba");
        publisher.setStreet("Streetname");
        publisher.setCity("City");
        publisher.setState("GA");
        publisher.setPostalCode("29992");
        publisher.setPhone("2323112");
        publisher.setEmail("asdasd@sdas.com");

        publisher2 = new Publisher();
        publisher2.setName("Samba");
        publisher2.setStreet("Streetname");
        publisher2.setCity("City");
        publisher2.setState("GA");
        publisher2.setPostalCode("29992");
        publisher2.setPhone("2323112");
        publisher2.setEmail("asdasd@sdas.com");

    }

    @Test
    public void createPublisher() {
        publisher = publisherDao.createPublisher(publisher);

        assertEquals(1, publisherDao.readAllPublishers().size());
    }

    @Test
    public void readPublisher() {
        publisher = publisherDao.createPublisher(publisher);

        Publisher foundPublisher = publisherDao.readPublisher(publisher.getPublisherId());

        assertEquals(foundPublisher, publisher);
    }

    @Test
    public void readAllPublishers() {
        publisher = publisherDao.createPublisher(publisher);
        publisher2 = publisherDao.createPublisher(publisher2);

        List<Publisher> publisherList = publisherDao.readAllPublishers();

        assertEquals(2,publisherList.size());
    }

    @Test
    public void updatePublisher() {
        publisher = publisherDao.createPublisher(publisher);
        publisher.setName("New Name");

        publisherDao.updatePublisher(publisher);

        Publisher updatedPublisher = publisherDao.readPublisher(publisher.getPublisherId());

        assertEquals(publisher, updatedPublisher);
    }

    @Test
    public void deletePublisher() {
        publisher = publisherDao.createPublisher(publisher);

        publisherDao.deletePublisher(publisher.getPublisherId());

        Publisher deletedPublisher = publisherDao.readPublisher(publisher.getPublisherId());

        assertNull(deletedPublisher);
    }
}