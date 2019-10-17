package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcTemplateImp implements GameDao{

    //prepared statements:
    private static final String INSERT_GAME_SQL =
            "INSERT INTO game (title, esrb_rating, description, price, studio, quantity) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_GAME_SQL =
            "SELECT * FROM game WHERE game_id = ?";
    private static final String SELECT_ALL_GAMES_SQL =
            "SELECT * FROM game";
    private static final String UPDATE_GAME_SQL =
            "UPDATE game SET title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? WHERE game_id = ?";
    private static final String DELETE_GAME_SQL =
            "DELETE FROM game WHERE game_id = ?";
    private static final String SELECT_GAME_BY_STUDIO_SQL =
            "SELECT * FROM game WHERE studio = ?";
    private static final String SELECT_GAME_BY_ESRB_SQL =
            "SELECT * FROM game WHERE esrb_rating = ?";
    private static final String SELECT_GAME_BY_TITLE_SQL =
            "SELECT * FROM game WHERE title = ?";

    // Jdbc Instantiation

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoJdbcTemplateImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * creates a new game
     *
     * @param game
     * @return
     */
    @Override
    public Game addGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        game.setGameId(id);
        return game;
    }

    /**
     * brings back a game with the specified Id from the db
     *
     * @param gameId
     * @return
     */
    @Override
    public Game getGame(int gameId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::rowMapperToGame, gameId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * returns a list of all games
     *
     * @return
     */
    @Override
    public List<Game> allGames() {
        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::rowMapperToGame);
    }

    /**
     * Updates a game in the db with the new body provided
     *
     * @param game
     */
    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getGameId());
    }

    /**
     * selects a game by the id and removes it from the db
     *
     * @param gameId
     */
    @Override
    public void deleteGame(int gameId) {
        jdbcTemplate.update(DELETE_GAME_SQL, gameId);
    }

    /**
     * returns a list of games given the studio
     *
     * @param studio
     * @return
     */
    @Override
    public List<Game> getGamesByStudio(String studio) {
        return jdbcTemplate.query(SELECT_GAME_BY_STUDIO_SQL, this::rowMapperToGame, studio);
    }

    /**
     * get a list of games with the same ESRB Rating
     *
     * @param esrbRating
     * @return
     */
    @Override
    public List<Game> getGamesByEsrbRating(String esrbRating) {
        return jdbcTemplate.query(SELECT_GAME_BY_ESRB_SQL, this::rowMapperToGame, esrbRating);
    }

    /**
     * get a game by its title
     *
     * @param title
     * @return
     */
    @Override
    public Game getGameByTile(String title) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_BY_TITLE_SQL,this::rowMapperToGame,title);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private Game rowMapperToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGameId(rs.getInt("game_id"));
        game.setTitle(rs.getString("title"));
        game.setEsrbRating(rs.getString("esrb_rating"));
        game.setDescription(rs.getString("description"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setStudio(rs.getString("studio"));
        game.setQuantity(rs.getInt("quantity"));

        return game;
    }
}
