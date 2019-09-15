package com.company.AndresInciarteU1M5Summative.Dao;

import com.company.AndresInciarteU1M5Summative.Dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbcTemplateImp implements PublisherDao {
    // prepared statements
    private static final String INSERT_PUBLISHER_SQL =
            "INSERT INTO publisher (name, street, city, state, postal_code, phone, email) VALUES (?,?,?,?,?,?,?)";
    private static final String SELECT_PUBLISHER_SQL =
            "SELECT * FROM publisher WHERE publisher_id = ?";
    private static final String SELECT_ALL_PUBLISHERS_SQL =
            "SELECT * FROM publisher";
    private static final String UPDATE_PUBLISHER_SQL =
            "UPDATE publisher SET name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? WHERE publisher_id = ?";
    private  static final String DELETE_PUBLISHER_SQL =
            "DELETE FROM publisher WHERE publisher_id = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PublisherDaoJdbcTemplateImp(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    /**
     * Create publisher
     *
     * @param publisher
     * @return
     */
    @Override
    public Publisher createPublisher(Publisher publisher) {
        jdbcTemplate.update(INSERT_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostalCode(),
                publisher.getPhone(),
                publisher.getEmail());

        Integer publisherId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        publisher.setPublisherId(publisherId);

        return publisher;
    }

    /**
     * read a publisher by id
     *
     * @param publisherId
     * @return
     */
    @Override
    public Publisher readPublisher(Integer publisherId) {
         try {
             return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::rowtoPublisherMapper ,publisherId);
         } catch (EmptyResultDataAccessException e) {
             return null;
         }
    }

    /**
     * read all publishers in db
     *
     * @return
     */
    @Override
    public List<Publisher> readAllPublishers() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHERS_SQL, this::rowtoPublisherMapper);
    }

    /**
     * update a publisher in the db
     *
     * @param publisher
     */
    @Override
    @Transactional
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostalCode(),
                publisher.getPhone(),
                publisher.getEmail(),
                publisher.getPublisherId());
    }

    /**
     * delete a publisher
     *
     * @param publisherId
     */
    @Override
    @Transactional
    public void deletePublisher(Integer publisherId) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, publisherId);
    }

    private Publisher rowtoPublisherMapper(ResultSet rs,int rowNum ) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setStreet(rs.getString("street"));
        publisher.setCity(rs.getString("city"));
        publisher.setState(rs.getString("state"));
        publisher.setPostalCode(rs.getString("postal_code"));
        publisher.setPhone(rs.getString("phone"));
        publisher.setEmail(rs.getString("email"));

        return publisher;
    }
}
