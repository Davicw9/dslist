package com.devsuperior.dslist.game.controler;

import com.devsuperior.dslist.game.dto.GameDto;
import com.devsuperior.dslist.game.dto.GameMinDto;
import com.devsuperior.dslist.game.entitie.Game;
import com.devsuperior.dslist.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
@CrossOrigin(origins = "*")
public class GameControler {

    @Autowired
    GameService gameService;

    @GetMapping("/findAll")
    public List<GameMinDto> findAll(){
        List<GameMinDto> games = gameService.findAll();
        return games;
    }

    @GetMapping("/findById/{id}")
    public GameDto findById(@PathVariable Long id){
        GameDto game = gameService.findById(id);
        return game;
    }
}
