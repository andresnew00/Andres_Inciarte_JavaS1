package com.company.CoffeeInventoryDaoAndresInciarte.dao;
import com.company.CoffeeInventoryDaoAndresInciarte.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoffeeInventoryDaoJdbcTemplateImp implements CoffeeInventoryDao{

    private static final String INSERT_COFFEE_SQL =
            "INSERT INTO coffee (roaster_id, name, count, unit_price, description, type) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_COFFEE_SQL =
            "SELECT * FROM coffee WHERE coffee_id = ?";

    private static final String SELECT_ALL_COFFEE_SQL =
            "SELECT * FROM coffee";

    private static final String UPDATE_COFFEE_SQL =
            "UPDATE coffee SET roaster_id = ?, name = ?, count = ?, unit_price = ?, description = ?, type = ? WHERE coffee_id = ?";

    private static final String DELETE_COFFEE_SQL =
            "DELETE FROM coffee WHERE coffee_id = ?";

    private static final String SELECT_COFFEE_BY_ROASTERID_SQL =
            "SELECT * FROM coffee WHERE roaster_id = ?";

    private static final String SELECT_COFFEE_BY_TYPE_SQL =
            "SELECT * FROM coffee WHERE type = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CoffeeInventoryDaoJdbcTemplateImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Create a new coffee
     *
     * @param coffee
     * @return
     */
    @Override
    public Coffee createCoffee(Coffee coffee) {
        jdbcTemplate.update(INSERT_COFFEE_SQL,
                coffee.getRoasterId(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnitPrice(),
                coffee.getDescription(),
                coffee.getType());

        int coffee_id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        coffee.setCoffeeId(coffee_id);

        return coffee;
    }

    /**
     * Return an existing coffee by id
     *
     * @param coffeeId
     * @return
     */
    @Override
    public Coffee readCoffee(int coffeeId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_COFFEE_SQL, this::mapToRowCoffee, coffeeId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Return all coffee in a list
     *
     * @return
     */
    @Override
    public List<Coffee> allCoffee() {
        return jdbcTemplate.query(SELECT_ALL_COFFEE_SQL, this::mapToRowCoffee);
    }

    /**
     * update a coffee in a list
     *
     * @param coffee
     */
    @Override
    public void updateCoffee(Coffee coffee) {
        jdbcTemplate.update(UPDATE_COFFEE_SQL,
                coffee.getCoffeeId(),
                coffee.getRoasterId(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnitPrice(),
                coffee.getDescription(),
                coffee.getType());
    }

    /**
     * delete a coffee in the list
     *
     * @param coffeeId
     */
    @Override
    public void deleteCoffee(int coffeeId) {
        jdbcTemplate.update(DELETE_COFFEE_SQL, coffeeId);
    }

    /**
     * return a coffee by roaster id
     *
     * @param roasterId
     * @return
     */
    @Override
    public List<Coffee> coffeeByRoaster(int roasterId) {
        return jdbcTemplate.query(SELECT_COFFEE_BY_ROASTERID_SQL, this::mapToRowCoffee, roasterId);
    }

    /**
     * return coffee by type
     *
     * @param type
     * @return
     */
    @Override
    public List<Coffee> coffeeByType(String type) {
        return jdbcTemplate.query(SELECT_COFFEE_BY_TYPE_SQL, this::mapToRowCoffee, type);
    }

    private Coffee mapToRowCoffee(ResultSet rs, int rowNum) throws SQLException {
        Coffee coffee = new Coffee();
        coffee.setCoffeeId(rs.getInt("coffee_id"));
        coffee.setRoasterId(rs.getInt("roaster_id"));
        coffee.setName(rs.getString("name"));
        coffee.setCount(rs.getInt("count"));
        coffee.setUnitPrice(rs.getDouble("unit_price"));
        coffee.setDescription(rs.getString("description"));
        coffee.setType(rs.getString("type"));

        return coffee;
    }
}
