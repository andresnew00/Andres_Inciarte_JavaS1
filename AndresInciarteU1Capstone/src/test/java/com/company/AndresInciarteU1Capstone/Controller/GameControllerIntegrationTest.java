package com.company.AndresInciarteU1Capstone.Controller;

import com.company.AndresInciarteU1Capstone.Dto.Console;
import com.company.AndresInciarteU1Capstone.Dto.Game;
import com.company.AndresInciarteU1Capstone.Service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

    }

    @Test
    public void getGameByIdShouldReturnGameWithIdJson() throws Exception {
        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("blocks!");
        game.setPrice(BigDecimal.valueOf(40,2));
        game.setStudio("Microsoft");
        game.setQuantity(30);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(game);

        // Mocking DAO response
        // This is another way to mock using mockito
        // same as doReturn(returnVal).when(repo).findById(8);
        // We could also set up our mocks in a separate method, if we so chose
        when(serviceLayer.getGame(1)).thenReturn(game);

        this.mockMvc.perform(get("/game/find/1"))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameThatDoesNotExistReturns404() throws Exception {

        // Create a Game with no value or id.
        // as that would be the expected behavior if we searched for a non-existant id
        Game game = null;

        int idForGameThatDoesNotExist = 100;

        when(serviceLayer.getGame(idForGameThatDoesNotExist)).thenReturn(game);

        this.mockMvc.perform(get("/game/find/" + idForGameThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void createGameShouldReturnCreatedGame() throws Exception {

        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("blocks!");
        game.setPrice(BigDecimal.valueOf(40,2));
        game.setStudio("Microsoft");
        game.setQuantity(30);

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(game);

        Game outputGame = new Game();
        outputGame.setGameId(1);
        outputGame.setTitle("Minecraft");
        outputGame.setEsrbRating("E");
        outputGame.setDescription("blocks!");
        outputGame.setPrice(BigDecimal.valueOf(40,2));
        outputGame.setStudio("Microsoft");
        outputGame.setQuantity(30);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputGame);

        when(serviceLayer.addGame(game)).thenReturn(outputGame);

        this.mockMvc.perform(post("/game")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllGamesShouldReturnAListOfGames() throws Exception {

        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("blocks!");
        game.setPrice(BigDecimal.valueOf(40,2));
        game.setStudio("Microsoft");
        game.setQuantity(30);

        Game game2 = new Game();
        game2.setGameId(1);
        game2.setTitle("Minecraft");
        game2.setEsrbRating("E");
        game2.setDescription("blocks!");
        game2.setPrice(BigDecimal.valueOf(40,2));
        game2.setStudio("Microsoft");
        game2.setQuantity(30);

        List<Game> GameList = new ArrayList<>();
        GameList.add(game);
        GameList.add(game2);

        //Object to JSON in String
        when(serviceLayer.getAllGames()).thenReturn(GameList);

        List<Game> GameListChecker = new ArrayList<>();
        GameListChecker.addAll(GameList);
        //To confirm the test is testing what we think it is... add another Rsvp.
        // Uncommenting the below line causes the test to fail. As expected!
        // listChecker.add(new Rsvp(10, "Donald Duck", 2));
        String outputJson = mapper.writeValueAsString(GameListChecker);

        this.mockMvc.perform(get("/game"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void updateGameShouldReturnAnUpdatedGame() throws Exception {

        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("blocks!");
        game.setPrice(BigDecimal.valueOf(40,2));
        game.setStudio("Microsoft");
        game.setQuantity(30);

        //these will be the same
        String inputJson = mapper.writeValueAsString(game);

        this.mockMvc.perform(put("/game/update/" + game.getGameId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteGameIsOkNoContentReturned() throws Exception {

        //can't mock the call to delete. it returns void
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/game/delete/1"))
                .andDo(print()).andExpect(status().isGone())
                .andExpect(content().string(""));
    }

    @Test
    public void findGamebytitle() throws Exception {
        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("blocks!");
        game.setPrice(BigDecimal.valueOf(40,2));
        game.setStudio("Microsoft");
        game.setQuantity(30);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(game);

        // Mocking DAO response
        // This is another way to mock using mockito
        // same as doReturn(returnVal).when(repo).findById(8);
        // We could also set up our mocks in a separate method, if we so chose
        when(serviceLayer.getGameByTitle("Minecraft")).thenReturn(game);

        this.mockMvc.perform(get("/game/findbytitle/Minecraft"))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGamesByEsrbRating() throws Exception {

        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("blocks!");
        game.setPrice(BigDecimal.valueOf(40,2));
        game.setStudio("Microsoft");
        game.setQuantity(30);

        Game game2 = new Game();
        game2.setGameId(1);
        game2.setTitle("Minecraft");
        game2.setEsrbRating("E");
        game2.setDescription("blocks!");
        game2.setPrice(BigDecimal.valueOf(40,2));
        game2.setStudio("Microsoft");
        game2.setQuantity(30);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);
        gameList.add(game2);


        List<Game> gameListChecker = new ArrayList<>();
        gameListChecker.addAll(gameList);

        String outputJson = mapper.writeValueAsString(gameList);

        when(serviceLayer.getGamesByEsrbRating("E")).thenReturn(gameList);

        this.mockMvc.perform(get("/game/findbyesrb/E"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
}

