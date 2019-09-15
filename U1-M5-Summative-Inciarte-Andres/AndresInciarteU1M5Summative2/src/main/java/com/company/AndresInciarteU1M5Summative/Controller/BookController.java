package com.company.AndresInciarteU1M5Summative.Controller;

import com.company.AndresInciarteU1M5Summative.Dao.BookDao;
import com.company.AndresInciarteU1M5Summative.Dao.PublisherDao;
import com.company.AndresInciarteU1M5Summative.Dto.Book;
import com.company.AndresInciarteU1M5Summative.Dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookDao bookDao;

    @PostMapping(value = "/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody @Valid Book book) {
        return bookDao.createBook(book);
    }

    @GetMapping(value = "/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book readBook(@PathVariable Integer id) {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be larger than 1");
        }
        return bookDao.readBook(id);
    }

    @GetMapping(value = "/book")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getAllBooks() {
        if (bookDao.readAllBooks().size() > 0) {
            return bookDao.readAllBooks();
        } else {
            throw new IllegalArgumentException("Books not found.");
        }
    }

    @PutMapping(value = "/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable Integer id,@RequestBody @Valid Book book) {
        book.setBookId(id); //TODO CHECK this might change the id number when the book is updated
        bookDao.updateBook(book);
    }

    @DeleteMapping(value = "/book/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteBook(@PathVariable Integer id) {
        if (bookDao.readAllBooks().contains(bookDao.readBook(id))) {
            bookDao.deleteBook(id);
        } else {
            throw new IllegalArgumentException("Book ID not Found");
        }
    }

    @GetMapping(value = "/books/{author_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> readBooksbyAuthor(@PathVariable Integer author_id) {
        if (author_id < 1) {
            throw new IllegalArgumentException("Author Id must be larger than 1");
        }
        return bookDao.bookByAuthor(author_id);
    }
}
