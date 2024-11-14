package com.devsuperior.dslist.GameList.service;

import com.devsuperior.dslist.GameList.dto.GameListDto;
import com.devsuperior.dslist.GameList.entitie.GameList;
import com.devsuperior.dslist.GameList.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional
    public List<GameListDto> findAll(){
        List<GameList> gameList = gameListRepository.findAll();
        List<GameListDto> dto = gameList.stream().map(x -> new GameListDto(x)).toList();
        return dto;
    }

}
