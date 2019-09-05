package com.company.CarLotDaoAndresInciarte.dao;

import com.company.CarLotDaoAndresInciarte.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarInventoryJdbcTemplateImpl implements CarLotDao{

    //Prepared statement strings
    private static final String INSERT_CAR_SQL =
            "INSERT INTO car (make, model, year, color) VALUES (?,?,?,?)";

    private static final String SELECT_CAR_SQL =
            "SELECT * FROM car WHERE id = ?";

    private static final String SELECT_ALL_CARS_SQL =
            "SELECT * FROM car";

    private static final String DELETE_CAR_SQL =
            "DELETE FROM car WHERE id = ?";

    private static final String UPDATE_CAR_SQL =
            "UPDATE car SET make = ?, model = ?, year = ?, color = ? WHERE id = ?";

    private static final String SELECT_CARS_BY_MAKE_SQL =
            "SELECT * FROM car WHERE make = ?";

    private static final String SELECT_CARS_BY_COLOR_SQL =
            "SELECT * FROM car WHERE color = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarInventoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Reading one car with the given id
     *
     * @param id
     * @return
     */
    @Override
    public Car getCar(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CAR_SQL, this::mapRowToCar, id);
        } catch (EmptyResultDataAccessException e) {
            //if nothing is returned just catch the exception and return null
            return null;
        }
    }

    /**
     * Returns all cars
     *
     * @return
     */
    @Override
    public List<Car> getAllCars() {
        return jdbcTemplate.query(SELECT_ALL_CARS_SQL, this::mapRowToCar);
    }

    /**
     * Create a car and adds it to the database
     *
     * @param car
     * @return
     */
    @Override
    public Car createCar(Car car) {
        jdbcTemplate.update(INSERT_CAR_SQL,
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getColor());
        int id = jdbcTemplate.queryForObject("SELECT last_insert_id()", Integer.class);

        car.setId(id);
        return car;
    }

    /**
     * Updates car with the matching id of the given car
     *
     * @param car
     */
    @Override
    public void updateCar(Car car) {
        jdbcTemplate.update(UPDATE_CAR_SQL,
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getColor(),
                car.getId());
    }

    /**
     * Delete a car from the database
     *
     * @param id
     */
    @Override
    public void deleteCar(int id) {
        jdbcTemplate.update(DELETE_CAR_SQL, id);
    }

    /**
     * Get all the cars int the list by make
     *
     * @param make
     * @return
     */
    @Override
    public List<Car> getCarsByMake(String make) {
        return jdbcTemplate.query(SELECT_CARS_BY_MAKE_SQL, this::mapRowToCar, make);
    }

    /**
     * Get all the cars in the list by color
     *
     * @param color
     * @return
     */
    @Override
    public List<Car> getCarsByColor(String color) {
        return jdbcTemplate.query(SELECT_CARS_BY_COLOR_SQL, this::mapRowToCar, color);
    }

    /**
     * Maps Cars table row to a car object
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    private Car mapRowToCar(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getString("year"));
        car.setColor(rs.getString("color"));

        return car;
    }
}
