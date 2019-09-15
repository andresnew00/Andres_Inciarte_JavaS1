package com.company.AndresInciarteU1M5Summative.Dao;

import com.company.AndresInciarteU1M5Summative.Dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDaoJdbcTemplateImp implements AuthorDao {
    // prepared statements
    private static final String INSERT_AUTHOR_SQL =
            "INSERT INTO author (first_name, last_name, street, city, state, postal_code, phone, email) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SELECT_AUTHOR_SQL =
            "SELECT * FROM author WHERE author_id = ?";
    private static final String SELECT_ALL_AUTHORS_SQL =
            "SELECT * FROM author";
    private static final String UPDATE_AUTHOR_SQL =
            "UPDATE author SET first_name = ? , last_name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? WHERE author_id = ? ";
    private static final String DELETE_AUTHOR_SQL =
            "DELETE FROM author WHERE author_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorDaoJdbcTemplateImp(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}
    /**
     * Creating an author
     *
     * @param author
     * @return
     */
    @Override
    public Author createAuthor(Author author) {
        jdbcTemplate.update(INSERT_AUTHOR_SQL,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostalCode(),
                author.getPhone(),
                author.getEmail());

        Integer authorId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        author.setAuthorId(authorId);
        return author;
    }

    /**
     * read author by Id
     *
     * @param authorId
     * @return
     */
    @Override
    public Author readAuthor(Integer authorId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_AUTHOR_SQL,this::rowToAuthorMapp,authorId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Returning all authors
     *
     * @return
     */
    @Override
    public List<Author> realAllAuthors() {
        return jdbcTemplate.query(SELECT_ALL_AUTHORS_SQL,this::rowToAuthorMapp);
    }

    /**
     * Update an existing author
     *
     * @param author
     */
    @Override
    @Transactional
    public void updateAuthor(Author author) {
        jdbcTemplate.update(UPDATE_AUTHOR_SQL,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostalCode(),
                author.getPhone(),
                author.getEmail(),
                author.getAuthorId());
    }

    /**
     * Delete an author by id
     *
     * @param authorId
     */
    @Override
    @Transactional
    public void deleteAuthor(Integer authorId) {
        jdbcTemplate.update(DELETE_AUTHOR_SQL, authorId);
    }

    private Author rowToAuthorMapp(ResultSet rs, int Rownum) throws SQLException {
        Author author = new Author();
        author.setAuthorId(rs.getInt("author_id"));
        author.setFirstName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        author.setStreet(rs.getString("street"));
        author.setCity(rs.getString("city"));
        author.setState(rs.getString("state"));
        author.setPostalCode(rs.getString("postal_code"));
        author.setPhone(rs.getString("phone"));
        author.setEmail(rs.getString("email"));

        return author;
    }
}
