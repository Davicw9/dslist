package com.devsuperior.dslist.GameList.service;

import com.devsuperior.dslist.GameList.dto.GameListDto;
import com.devsuperior.dslist.GameList.entitie.GameList;
import com.devsuperior.dslist.GameList.repository.GameListRepository;
import com.devsuperior.dslist.game.projection.GameMinProjection;
import com.devsuperior.dslist.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public List<GameListDto> findAll(){
        List<GameList> gameList = gameListRepository.findAll();
        List<GameListDto> dto = gameList.stream().map(x -> new GameListDto(x)).toList();
        return dto;
    }

}
/*
    @Transactional(readOnly = true)
    public void move(Long listId ,int sourceIndex, int destinationIndex){

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;
        int min = sourceIndex > destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }*/