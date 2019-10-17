package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TshirtDaoJdbcTemplateImp implements TshirtDao{

    //prepared statements:
    private static final String INSERT_TSHIRT_SQL =
            "INSERT INTO t_shirt (size, color, description, price, quantity) VALUES (?,?,?,?,?)";
    private static final String SELECT_TSHIRT_SQL =
            "SELECT * FROM t_shirt WHERE t_shirt_id = ?";
    private static final String SELECT_ALL_TSHIRT_SQL =
            "SELECT * FROM t_shirt";
    private static final String UPDATE_TSHIRT_SLQ =
            "UPDATE t_shirt SET size = ?, color = ?, description = ?, price = ? , quantity = ? WHERE t_shirt_id = ?";
    private static final String DELETE_TSHIRT_SQL =
            "DELETE FROM t_shirt WHERE t_shirt_id = ?";
    private static final String SELECT_TSHIRT_BY_COLOR_SQL =
            "SELECT * FROM t_shirt WHERE color = ?";
    private  static final String SELECT_TSHIRT_BY_SIZE_SQL =
            "SELECT * FROM t_shirt WHERE size = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TshirtDaoJdbcTemplateImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * add a new tshirt to the db
     *
     * @param tShirt
     * @return
     */
    @Override
    public TShirt addTshirt(TShirt tShirt) {

         jdbcTemplate.update(INSERT_TSHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity());
         int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

         tShirt.settShirtId(id);
         return tShirt;
    }

    /**
     * get a tshirt by number
     *
     * @param tShirtId
     * @return
     */
    @Override
    public TShirt getTshirt(int tShirtId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TSHIRT_SQL,this::rowMapToTshirt, tShirtId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * get all shirts in the database
     *
     * @return
     */
    @Override
    public List<TShirt> getAllTshirts() {
        return jdbcTemplate.query(SELECT_ALL_TSHIRT_SQL,this::rowMapToTshirt);
    }

    /**
     * update a shirt in the database
     *
     * @param tShirt
     */
    @Override
    public void updateTshirt(TShirt tShirt) {
        //t_shirt_id int(11) not null auto_increment primary key,
        //    size varchar(20) not null,
        //    color varchar(20) not null,
        //    description varchar(255) not null,
        //    price decimal(5,2) not null,
        //    quantity int(11) not null
        jdbcTemplate.update(UPDATE_TSHIRT_SLQ,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity(),
                tShirt.gettShirtId());
    }

    /**
     * delete a shirt from the database
     *
     * @param tShirtId
     */
    @Override
    public void deleteTshirt(int tShirtId) {
        jdbcTemplate.update(DELETE_TSHIRT_SQL,tShirtId);
    }

    /**
     * get all shirts of the same color
     *
     * @param color
     * @return
     */
    @Override
    public List<TShirt> getTshirtsByColor(String color) {
        return jdbcTemplate.query(SELECT_TSHIRT_BY_COLOR_SQL,this::rowMapToTshirt,color);
    }

    /**
     * get all shirts of the same size
     *
     * @param size
     * @return
     */
    @Override
    public List<TShirt> getTshirtsBySize(String size) {
        return jdbcTemplate.query(SELECT_TSHIRT_BY_SIZE_SQL, this::rowMapToTshirt, size);
    }

    private TShirt rowMapToTshirt(ResultSet rs, int rowNum) throws SQLException {
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(rs.getInt("t_shirt_id"));
        tShirt.setSize(rs.getString("size"));
        tShirt.setColor(rs.getString("color"));
        tShirt.setDescription(rs.getString("description"));
        tShirt.setPrice(rs.getBigDecimal("price"));
        tShirt.setQuantity(rs.getInt("quantity"));

        return tShirt;
    }
}
