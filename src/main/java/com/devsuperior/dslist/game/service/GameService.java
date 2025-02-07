package com.devsuperior.dslist.game.service;


import com.devsuperior.dslist.game.dto.GameDto;
import com.devsuperior.dslist.game.dto.GameMinDto;
import com.devsuperior.dslist.game.entitie.Game;
import com.devsuperior.dslist.game.exceptions.GameNotFoundByIdException;
import com.devsuperior.dslist.game.projection.GameMinProjection;
import com.devsuperior.dslist.game.repository.GameRepository;
import com.devsuperior.dslist.util.ObjectMapperUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.devsuperior.dslist.util.BeanUtilsHelper.getNullPropertyNames;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public Game findById(Long id) {
        // Busca o professor no repositório pelo ID
        return gameRepository.findById(id)
                // Se o game não for encontrado, lança uma exceção personalizada
                .orElseThrow(() -> new GameNotFoundByIdException("Jogo nao encontrado pelo id: " + id));
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Transactional(readOnly = true)
    public List<Game> findAll(){

        return gameRepository.findAll();
    }

    public Game update(Long id, Game game) {
        Game existingGame = findById(id);

        // Copia as propriedades do objeto Game para o Game existente, ignorando propriedades nulas
        BeanUtils.copyProperties(game, existingGame, getNullPropertyNames(game));
        return gameRepository.save(game);
    }

    @Transactional(readOnly = true)
    public List<Game> findByList(Long id) {
        return gameRepository.searchByList(id);
    }

    @Transactional
    public void delete(Long id) {
        // Verifica se o professor existe no banco de dados
        if (!gameRepository.existsById(id)) {
            // Lança uma exceção personalizada caso o professor não seja encontrado
            throw new GameNotFoundByIdException("Professor não encontrado.");
        }
        // Deleta o professor do banco de dados
        gameRepository.deleteById(id);
    }
}
