package com.devsuperior.dslist.game.service;


import com.devsuperior.dslist.game.dto.GameMinDto;
import com.devsuperior.dslist.game.entitie.Game;
import com.devsuperior.dslist.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public List<GameMinDto> findAll(){
        List<Game> list = gameRepository.findAll();
        List<GameMinDto> dto = list.stream().map(x -> new GameMinDto(x)).toList();
        return dto;
    }
}
