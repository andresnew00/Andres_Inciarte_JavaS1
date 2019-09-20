package com.company.AndresInciarteU1Capstone.Controller;

import com.company.AndresInciarteU1Capstone.Dto.Game;
import com.company.AndresInciarteU1Capstone.Service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Game addGame(@RequestBody @Valid Game game){
        return serviceLayer.addGame(game);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames() {
        if (serviceLayer.getAllGames().size() > 0) {
            return serviceLayer.getAllGames();
        } else {
            throw new IllegalArgumentException("Games not found.");
        }
    }

    @GetMapping(value = "/{gameId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGame(@PathVariable int gameId) {
        return serviceLayer.getGame(gameId);
    }


    @PutMapping(value = "/{gameId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateGame(@PathVariable int id,@RequestBody @Valid Game game) {
        game.setGameId(id);
        serviceLayer.updateGame(game);
    }

    @DeleteMapping(value = "/{gameId}")
    @ResponseStatus(value = HttpStatus.GONE)
    public void deleteGame(@PathVariable int gameId) {
        serviceLayer.deleteGame(gameId);
    }

    @GetMapping(value = "/{studio}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGamesbyStudio(@PathVariable String studio) {
        if (serviceLayer.getGamesByStudio(studio).size() > 0) {
            return serviceLayer.getGamesByStudio(studio);
        } else {
            throw new IllegalArgumentException("Games not found in that studio.");
        }
    }

    @GetMapping(value = "/{esrb}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGamesbyEsrb(@PathVariable String esrb) {
        if (serviceLayer.getGamesByEsrbRating(esrb).size() > 0) {
            return serviceLayer.getGamesByEsrbRating(esrb);
        } else {
            throw new IllegalArgumentException("Games not found with that esrb rating.");
        }
    }

    @GetMapping(value = "/{title}")
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGameByTitle(@PathVariable String title) {
        return serviceLayer.getGameByTitle(title);
    }

}
