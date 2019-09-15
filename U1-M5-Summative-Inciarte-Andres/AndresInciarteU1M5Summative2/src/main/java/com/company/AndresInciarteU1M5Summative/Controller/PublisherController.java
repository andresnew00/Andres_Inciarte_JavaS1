package com.company.AndresInciarteU1M5Summative.Controller;

import com.company.AndresInciarteU1M5Summative.Dao.AuthorDao;
import com.company.AndresInciarteU1M5Summative.Dao.PublisherDao;
import com.company.AndresInciarteU1M5Summative.Dto.Author;
import com.company.AndresInciarteU1M5Summative.Dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PublisherController {

    @Autowired
    private PublisherDao publisherDao;

    @PostMapping(value = "/publisher")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher createPublisher(@RequestBody @Valid Publisher publisher) {
        return publisherDao.createPublisher(publisher);
    }

    @GetMapping(value = "/publisher/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher readPublisher(@PathVariable Integer id) {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be larger than 1");
        }
        return publisherDao.readPublisher(id);
    }

    @GetMapping(value = "/publishers")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Publisher> getAllPublishers() {
        if (publisherDao.readAllPublishers().size() > 0) {
            return publisherDao.readAllPublishers();
        } else {
            throw new IllegalArgumentException("Publishers not found.");
        }
    }

    @PutMapping(value = "/publisher/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePublisher(@PathVariable Integer id,@RequestBody @Valid Publisher publisher) {
        publisher.setPublisherId(id);
        publisherDao.updatePublisher(publisher);
    }

    @DeleteMapping(value = "/publisher/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deletePublisher(@PathVariable Integer id) {
        if (publisherDao.readAllPublishers().contains(publisherDao.readPublisher(id))) {
            publisherDao.deletePublisher(id);
        } else {
            throw new IllegalArgumentException("Author ID not Found");
        }
    }
}
