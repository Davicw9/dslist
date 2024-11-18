package com.devsuperior.dslist.GameList.controller;


import com.devsuperior.dslist.GameList.dto.GameListDto;
import com.devsuperior.dslist.GameList.service.GameListService;
import com.devsuperior.dslist.game.dto.GameMinDto;
import com.devsuperior.dslist.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
@CrossOrigin(origins = "*")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping("/findAll")
    public List<GameListDto> findAll(){
        List<GameListDto> dto = gameListService.findAll();
        return dto;
    }
    @GetMapping("/findByList/{id}/games")
    public List<GameMinDto> findByList(@PathVariable Long id){
        List<GameMinDto> dto = gameService.findByList(id);
        return dto;
    }
}
