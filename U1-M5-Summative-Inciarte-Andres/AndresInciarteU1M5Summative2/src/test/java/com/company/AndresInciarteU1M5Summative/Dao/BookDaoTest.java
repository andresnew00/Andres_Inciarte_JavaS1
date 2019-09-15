package com.company.AndresInciarteU1M5Summative.Dao;

import com.company.AndresInciarteU1M5Summative.Dto.Author;
import com.company.AndresInciarteU1M5Summative.Dto.Book;
import com.company.AndresInciarteU1M5Summative.Dto.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private PublisherDao publisherDao;

    private Author author;

    private Publisher publisher;

    private Book book, book2;

    @Before
    public void setUp() throws Exception {

        bookDao.readAllBooks().forEach(book -> {
            bookDao.deleteBook(book.getBookId());
        });
        publisherDao.readAllPublishers().forEach(publisher -> {
            publisherDao.deletePublisher(publisher.getPublisherId());
        });
        authorDao.realAllAuthors().forEach(author -> {
            authorDao.deleteAuthor(author.getAuthorId());
        });

        author = new Author();
        author.setFirstName("Andres");
        author.setLastName("Inciarte");
        author.setStreet("street");
        author.setCity("lawrenceville");
        author.setState("GA");
        author.setPostalCode("20000");
        author.setPhone("111111111");
        author.setEmail("emiail.com");


        publisher = new Publisher();
        publisher.setName("Lucy");
        publisher.setStreet("streer");
        publisher.setCity("Cty");
        publisher.setState("GA");
        publisher.setPostalCode("20003");
        publisher.setPhone("12121212");
        publisher.setEmail("dbaskd.com");


        book = new Book();
        book.setIsbn("398478923ASDAS");
        book.setPublishDate(LocalDate.of(2018,12,11));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Title");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new Long(100));


        book2 = new Book();
        book2.setIsbn("3984733323ASDAS");
        book2.setPublishDate(LocalDate.of(2018,10,22));
        book2.setAuthorId(author.getAuthorId());
        book2.setTitle("Title2");
        book2.setPublisherId(publisher.getPublisherId());
        book2.setPrice(new Long(200));

    }

    @Test
    public void createBook() {
        author = authorDao.createAuthor(author);
        book.setAuthorId(author.getAuthorId());

        publisher = publisherDao.createPublisher(publisher);
        book.setPublisherId(publisher.getPublisherId());
        book = bookDao.createBook(book);

        assertEquals(1,bookDao.readAllBooks().size());
    }

    @Test
    public void readBook() {
        author = authorDao.createAuthor(author);
        book.setAuthorId(author.getAuthorId());

        publisher = publisherDao.createPublisher(publisher);
        book.setPublisherId(publisher.getPublisherId());

        book = bookDao.createBook(book);

        Book checkBook = bookDao.readBook(book.getBookId());

        assertEquals(checkBook, book);
    }

    @Test
    public void readAllBooks() {
        book.setAuthorId(author.getAuthorId());

        book.setPublisherId(publisher.getPublisherId());

        book = bookDao.createBook(book);

        book2.setAuthorId(author.getAuthorId());

        book2.setPublisherId(publisher.getPublisherId());

        book2 = bookDao.createBook(book2);

        List<Book> bookList = bookDao.readAllBooks();

        assertEquals(2, bookList.size());
    }

    @Test
    public void updateBook() {
        book.setAuthorId(author.getAuthorId());

        book.setPublisherId(publisher.getPublisherId());

        book = bookDao.createBook(book);
        book.setTitle("new title");

        bookDao.updateBook(book);

        Book updatedBook = bookDao.readBook(book.getBookId());

        assertEquals(updatedBook, book);
    }

    @Test
    public void deleteBook() {
        book.setAuthorId(author.getAuthorId());

        book.setPublisherId(publisher.getPublisherId());

        book = bookDao.createBook(book);
        bookDao.deleteBook(book.getBookId());

        Book deletedBook = bookDao.readBook(book.getBookId());

        assertNull(deletedBook);
    }

    @Test
    public void bookByAuthor() {
        book.setAuthorId(author.getAuthorId());

        book.setPublisherId(publisher.getPublisherId());

        book = bookDao.createBook(book);

        bookDao.bookByAuthor(author.getAuthorId());

        Book bookByAuthor = bookDao.readBook(book.getBookId());

        assertEquals(bookByAuthor, book);
    }
}