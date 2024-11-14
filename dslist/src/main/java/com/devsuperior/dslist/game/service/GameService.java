package com.devsuperior.dslist.game.service;


import com.devsuperior.dslist.game.dto.GameDto;
import com.devsuperior.dslist.game.dto.GameMinDto;
import com.devsuperior.dslist.game.entitie.Game;
import com.devsuperior.dslist.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        List<Game> list = gameRepository.findAll();
        List<GameMinDto> dto = list.stream().map(x -> new GameMinDto(x)).toList();
        return dto;
    }
    @Transactional(readOnly = true)
    public GameDto findById(Long id){
        Game game = gameRepository.findById(id).get();
        GameDto dto = new GameDto(game);
        return dto;
    }
}
