package com.company.AndresInciarteU1M5Summative.Controller;

import com.company.AndresInciarteU1M5Summative.Dao.AuthorDao;
import com.company.AndresInciarteU1M5Summative.Dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorDao authorDao;

    @PostMapping(value = "/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody @Valid Author author) {
        return authorDao.createAuthor(author);
    }

    @GetMapping(value = "/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author readAuthor(@PathVariable Integer id) {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be larger than 1");
        }
        return authorDao.readAuthor(id);
    }

    @GetMapping(value = "/authors")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Author> getAllAuthors() {
        if (authorDao.realAllAuthors().size() > 0) {
            return authorDao.realAllAuthors();
        } else {
            throw new IllegalArgumentException("Authors not found.");
        }
    }

    @PutMapping(value = "/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAuthor(@PathVariable Integer id,@RequestBody @Valid Author author) {
        author.setAuthorId(id);
        authorDao.updateAuthor(author);
    }

    @DeleteMapping(value = "/author/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteAuthor(@PathVariable Integer id) {
        if (authorDao.realAllAuthors().contains(authorDao.readAuthor(id))) {
            authorDao.deleteAuthor(id);
        } else {
            throw new IllegalArgumentException("Author ID not Found");
        }
    }

}
