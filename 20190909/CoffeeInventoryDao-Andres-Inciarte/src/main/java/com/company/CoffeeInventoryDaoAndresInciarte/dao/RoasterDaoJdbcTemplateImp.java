package com.company.CoffeeInventoryDaoAndresInciarte.dao;

import com.company.CoffeeInventoryDaoAndresInciarte.model.Coffee;
import com.company.CoffeeInventoryDaoAndresInciarte.model.Roaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoasterDaoJdbcTemplateImp implements RoasterDao{

    private static final String INSERT_ROASTER_SQL =
            "INSERT INTO roaster ( name, street, city, state, postal_code, phone, email, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ROASTER_SQL =
            "SELECT * FROM roaster WHERE roaster_id = ?";

    private static final String SELECT_ALL_ROASTER_SQL =
            "SELECT * FROM roaster";

    private static final String UPDATE_ROASTER_SQL =
            "UPDATE roaster SET name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ?, note = ? WHERE roaster_id = ?";

    private static final String DELETE_ROASTER_SQL =
            "DELETE FROM roaster WHERE roaster_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RoasterDaoJdbcTemplateImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Create a new roaster
     *
     * @param roaster
     * @return
     */
    @Override
    public Roaster createRoaster(Roaster roaster) {
        jdbcTemplate.update(INSERT_ROASTER_SQL,
                roaster.getName(),
                roaster.getStreet(),
                roaster.getCity(),
                roaster.getState(),
                roaster.getPostalCode(),
                roaster.getPhone(),
                roaster.getEmail(),
                roaster.getNote()
                );

        int roaster_id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        roaster.setRoasterId(roaster_id);

        return roaster;
    }

    /**
     * Return an existing roaster by id
     *
     * @param roasterId
     * @return
     */
    @Override
    public Roaster readRoaster(int roasterId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_ROASTER_SQL, this::mapToRowRoaster, roasterId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Return all roaster in a list
     *
     * @return
     */
    @Override
    public List<Roaster> allRoasters() {
        return jdbcTemplate.query(SELECT_ALL_ROASTER_SQL, this::mapToRowRoaster);
    }

    /**
     * update a roaster in a list
     *
     * @param roaster
     */
    @Override
    public void updateRoaster(Roaster roaster) {
        jdbcTemplate.update(UPDATE_ROASTER_SQL,
                roaster.getName(),
                roaster.getStreet(),
                roaster.getCity(),
                roaster.getState(),
                roaster.getPostalCode(),
                roaster.getPhone(),
                roaster.getEmail(),
                roaster.getNote(),
                roaster.getRoasterId()
        );
    }

    /**
     * delete a roaster in the list
     *
     * @param roasterId
     */
    @Override
    public void deleteRoaster(int roasterId) {
        jdbcTemplate.update(DELETE_ROASTER_SQL, roasterId);
    }

    private Roaster mapToRowRoaster(ResultSet rs, int rowNum) throws SQLException {
        Roaster roaster = new Roaster();
        roaster.setRoasterId(rs.getInt("roaster_id"));
        roaster.setName(rs.getString("name"));
        roaster.setCity(rs.getString("city"));
        roaster.setState(rs.getString("state"));
        roaster.setPostalCode(rs.getString("postal_code"));
        roaster.setPhone(rs.getString("phone"));
        roaster.setEmail(rs.getString("email"));
        roaster.setNote(rs.getString("note"));

        return roaster;
    }
}
