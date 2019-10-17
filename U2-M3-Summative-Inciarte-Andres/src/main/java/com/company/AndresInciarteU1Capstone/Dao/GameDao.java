package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.Game;

import java.util.List;

public interface GameDao {

    /**
     * creates a new game
     * @param game
     * @return
     */
    Game addGame(Game game);

    /**
     * brings back a game with the specified Id from the db
     * @param gameId
     * @return
     */
    Game getGame(int gameId);

    /**
     * returns a list of all games
     * @return
     */
    List<Game> allGames();

    /**
     *  Updates a game in the db with the new body provided
     * @param game
     */
    void updateGame(Game game);

    /**
     * selects a game by the id and removes it from the db
     * @param gameId
     */
    void deleteGame(int gameId);

    // search games by studio

    /**
     * returns a list of games given the studio
     * @param studio
     * @return
     */
    List<Game> getGamesByStudio(String studio);

    // search games by ESRB Rating

    /**
     * get a list of games with the same ESRB Rating
     * @param esrbRating
     * @return
     */
    List<Game> getGamesByEsrbRating(String esrbRating);

    // search by title

    /**
     * get a game by its title
     * @param title
     * @return
     */
    Game getGameByTile(String title);
}
