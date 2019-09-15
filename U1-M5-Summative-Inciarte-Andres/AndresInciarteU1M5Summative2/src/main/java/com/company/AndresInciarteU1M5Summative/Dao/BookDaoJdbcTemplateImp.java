package com.company.AndresInciarteU1M5Summative.Dao;

import com.company.AndresInciarteU1M5Summative.Dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbcTemplateImp implements BookDao {
    // Prepared statements
    private static final String INSERT_BOOK_SQL =
            "INSERT INTO book (isbn, publish_date, author_id, title, publisher_id, price) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_BOOK_SQL =
            "SELECT * FROM book WHERE book_id = ?";
    private static final String SELECT_ALL_BOOKS_SQL =
            "SELECT * FROM book";
    private static final String UPDATE_BOOK_SQL =
            "UPDATE book SET isbn = ?, publish_date = ?, author_id = ?, title = ?, publisher_id = ?, price = ? WHERE book_id = ?";
    private static final String DELETE_BOOK_SQL =
            "DELETE FROM book WHERE book_id = ?";
    private static final String SELECT_BOOKS_BY_AUTHOR_SQL =
            "SELECT * FROM book WHERE author_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoJdbcTemplateImp(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate;}
    /**
     * Create a new book
     *
     * @param book
     * @return
     */
    @Override
    @Transactional
    public Book createBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice());
        Integer bookId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        book.setBookId(bookId);
        return book;
    }

    /**
     * Read a book by id
     *
     * @param id
     * @return
     */
    @Override
    public Book readBook(Integer id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * get a list of all the books in the db
     *
     * @return
     */
    @Override
    public List<Book> readAllBooks() {
        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL, this::mapRowToBook);
    }

    /**
     * Updating a book in the database
     *
     * @param book
     */
    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getBookId());
    }

    /**
     * Delete a book from the database
     *
     * @param id
     */
    @Override
    public void deleteBook(Integer id) {
        jdbcTemplate.update(DELETE_BOOK_SQL, id);
    }

    /**
     * Get books by Author
     *
     * @param authorId
     * @return
     */
    @Override
    public List<Book> bookByAuthor(Integer authorId) {
        return jdbcTemplate.query(SELECT_BOOKS_BY_AUTHOR_SQL, this::mapRowToBook, authorId);
    }

    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setIsbn(rs.getString("isbn"));
        book.setPublishDate(rs.getDate("publish_date").toLocalDate());
        book.setAuthorId(rs.getInt("author_id"));
        book.setTitle(rs.getString("title"));
        book.setPublisherId(rs.getInt("publisher_id"));
        book.setPrice(rs.getLong("price"));

        return book;
    }

}
