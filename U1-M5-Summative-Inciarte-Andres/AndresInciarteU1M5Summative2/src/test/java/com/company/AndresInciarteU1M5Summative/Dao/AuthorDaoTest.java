package com.company.AndresInciarteU1M5Summative.Dao;

import com.company.AndresInciarteU1M5Summative.Dto.Author;
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
public class AuthorDaoTest {

    @Autowired
    private AuthorDao authorDao;


    private Author author, author2;

    @Before
    public void setUp() throws Exception {

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

        author2 = new Author();
        author2.setFirstName("Andres");
        author2.setLastName("Inciarte");
        author2.setStreet("street");
        author2.setCity("lawrenceville");
        author2.setState("GA");
        author2.setPostalCode("20000");
        author2.setPhone("111111111");
        author2.setEmail("emiail.com");
    }


    @Test
    public void createAuthor() {
        author = authorDao.createAuthor(author);

        assertEquals(1, authorDao.realAllAuthors().size());
    }

    @Test
    public void readAuthor() {
        author = authorDao.createAuthor(author);

        Author authorFound = authorDao.readAuthor(author.getAuthorId());

        assertEquals(author, authorFound);
    }

    @Test
    public void realAllAuthors() {
        author = authorDao.createAuthor(author);
        author2 = authorDao.createAuthor(author2);

        List<Author> authorList = authorDao.realAllAuthors();

        assertEquals(2,authorList.size());
    }

    @Test
    public void updateAuthor() {
    author = authorDao.createAuthor(author);
    author.setLastName("Dre");

    authorDao.updateAuthor(author);

    Author updatedAuthor = authorDao.readAuthor(author.getAuthorId());

    assertEquals(updatedAuthor,author);
    }

    @Test
    public void deleteAuthor() {
        author = authorDao.createAuthor(author);

        authorDao.deleteAuthor(author.getAuthorId());

        Author tryGetAuthor = authorDao.readAuthor(author.getAuthorId());

        assertNull(tryGetAuthor);
    }
}