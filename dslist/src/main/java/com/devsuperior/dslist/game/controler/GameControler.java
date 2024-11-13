package com.devsuperior.dslist.game.controler;

import com.devsuperior.dslist.game.dto.GameMinDto;
import com.devsuperior.dslist.game.entitie.Game;
import com.devsuperior.dslist.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameControler {

    @Autowired
    GameService gameService;

    @GetMapping("/findAll")
    public List<GameMinDto> findAll(){
        List<GameMinDto> games = gameService.findAll();
        return games;
    }
}
