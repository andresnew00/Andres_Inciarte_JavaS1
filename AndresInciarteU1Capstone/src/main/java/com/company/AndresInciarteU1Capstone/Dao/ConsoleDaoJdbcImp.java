package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoJdbcImp implements ConsoleDao {

    // prepared statements:
    private static final String INSERT_CONSOLE_SQL =
            "INSERT INTO console (model, manufacturer, memory_amount, processor, price, quantity) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_CONSOLE_SQL =
            "SELECT * FROM console WHERE console_id = ?";
    private static final String SELECT_ALL_CONSOLES_SQL =
            "SELECT * FROM console";
    private static final String UPDATE_CONSOLE_SQL =
            "UPDATE console SET model = ?, manufacturer = ?, memory_amount = ?, processor = ?, price = ?, quantity = ? WHERE console_id = ?";
    private static final String DELETE_CONSOLE_SQL =
            "DELETE FROM console WHERE console_id = ?";
    private static final String SELECT_ALL_CONSOLES_BY_MANUFACTURER =
            "SELECT * FROM console WHERE manufacturer = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsoleDaoJdbcImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * create a new console instance in the db
     *
     * @param console
     * @return
     */
    @Override
    public Console addConsole(Console console) {
        jdbcTemplate.update(INSERT_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",Integer.class);

        console.setConsoleId(id);

        return console;
    }

    /**
     * retrieve a console from the db by its id
     *
     * @param consoleId
     * @return
     */
    @Override
    public Console getConsole(int consoleId) {

        try {
            return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::rowMapperToConsole, consoleId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    /**
     * get all the consoles currently in the db
     *
     * @return
     */
    @Override
    public List<Console> getAllConsoles() {
        return jdbcTemplate.query(SELECT_ALL_CONSOLES_SQL, this::rowMapperToConsole);
    }

    /**
     * update a console in the db
     *
     * @param console
     */
    @Override
    public void updateConsole(Console console) {
        jdbcTemplate.update(UPDATE_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity(),
                console.getConsoleId());
    }

    /**
     * delete a console from the db using its id
     *
     * @param consoleId
     */
    @Override
    public void deleteConsole(int consoleId) {
        jdbcTemplate.update(DELETE_CONSOLE_SQL,consoleId);
    }

    /**
     * get all the consoles by the same manufacturer
     *
     * @param manufacturer
     * @return
     */
    @Override
    public List<Console> getConsoleByManufacturer(String manufacturer) {
        return jdbcTemplate.query(SELECT_ALL_CONSOLES_BY_MANUFACTURER, this::rowMapperToConsole, manufacturer);
    }

    private Console rowMapperToConsole(ResultSet rs, int rowNum) throws SQLException {
        Console console = new Console();
        console.setConsoleId(rs.getInt("console_id"));
        console.setModel(rs.getString("model"));
        console.setManufacturer(rs.getString("manufacturer"));
        console.setMemoryAmount(rs.getString("memory_amount"));
        console.setProcessor(rs.getString("processor"));
        console.setPrice(rs.getBigDecimal("price"));
        console.setQuantity(rs.getInt("quantity"));

        return console;
    }
}
