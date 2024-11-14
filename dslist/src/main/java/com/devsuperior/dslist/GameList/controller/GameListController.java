package com.devsuperior.dslist.GameList.controller;


import com.devsuperior.dslist.GameList.dto.GameListDto;
import com.devsuperior.dslist.GameList.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping("/findAll")
    public List<GameListDto> findAll(){
        List<GameListDto> dto = gameListService.findAll();
        return dto;
    }
}
