package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {

    @Autowired
    GameDao gameDao;

    private Game game, game2;

    @Before
    public void setUp() throws Exception {

        gameDao.allGames().forEach(game -> {gameDao.deleteGame(game.getGameId());});

        game = new Game();
        game.setTitle("Zelda");
        game.setEsrbRating("E");
        game.setDescription("is link not zelda");
        game.setPrice(BigDecimal.valueOf(60,2 ));
        game.setStudio("Nintendo");
        game.setQuantity(20);

        game2 = new Game();
        game2.setTitle("Mario");
        game2.setEsrbRating("X");
        game2.setDescription("Here we go!");
        game2.setPrice(BigDecimal.valueOf(60,2));
        game2.setStudio("Nintendo");
        game2.setQuantity(30);
    }

    @Test
    public void addGame() {
        game = gameDao.addGame(game);

        assertEquals(1,gameDao.allGames().size());
    }

    @Test
    public void getGame() {
        game = gameDao.addGame(game);

        Game getGame = gameDao.getGame(game.getGameId());

        assertEquals(getGame, game);
    }

    @Test
    public void allGames() {
        game = gameDao.addGame(game);
        game2 = gameDao.addGame(game2);

        List<Game> gameList = gameDao.allGames();

        assertEquals(2,gameList.size());
    }

    @Test
    public void updateGame() {
        game = gameDao.addGame(game);
        game.setDescription("Link can be named Zelda lol");

        gameDao.updateGame(game);

        Game updatedGame = gameDao.getGame(game.getGameId());

        assertEquals(game,updatedGame);
    }

    @Test
    public void deleteGame() {
        game = gameDao.addGame(game);

        gameDao.deleteGame(game.getGameId());

        Game deletedGame = gameDao.getGame(game.getGameId());

        assertNull(deletedGame);
    }

    @Test
    public void getGamesByStudio() {
        game = gameDao.addGame(game);
        game2 = gameDao.addGame(game2);

        List<Game> gameList = gameDao.getGamesByStudio("Nintendo");

        assertEquals(2,gameList.size());
    }

    @Test
    public void getGamesByEsrbRating() {
        game = gameDao.addGame(game);
        game2 = gameDao.addGame(game2);

        List<Game> gameList = gameDao.getGamesByEsrbRating("E");

        assertEquals(1,gameList.size());
    }

    @Test
    public void getGameByTile() {
        game = gameDao.addGame(game);
        game2 = gameDao.addGame(game2);

        Game getTitledGame = gameDao.getGameByTile("Zelda");

        assertEquals(getTitledGame, game);
    }
}