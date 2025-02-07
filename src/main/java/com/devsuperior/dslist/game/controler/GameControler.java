package com.devsuperior.dslist.game.controler;

import com.devsuperior.dslist.game.dto.GameDto;
import com.devsuperior.dslist.game.dto.GameMinDto;
import com.devsuperior.dslist.game.entitie.Game;
import com.devsuperior.dslist.game.service.GameService;
import com.devsuperior.dslist.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
@CrossOrigin(origins = "*")
public class GameControler {

    @Autowired
    GameService gameService;

    private final ObjectMapperUtil objectMapperUtil;

    public GameControler(ObjectMapperUtil objectMapperUtil) {
        this.objectMapperUtil = objectMapperUtil;
    }

    @PostMapping("/save")
    public ResponseEntity<GameDto> save(@RequestBody GameDto gameDto) {

        Game game = objectMapperUtil.map(gameDto, Game.class);
        Game savedGame = gameService.save(game);
        GameDto dto = objectMapperUtil.map(savedGame, GameDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<GameDto> findById(@PathVariable Long id) {
        Game game = gameService.findById(id);
        GameDto dto = objectMapperUtil.map(game, GameDto.class);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<GameMinDto>> findAll() {
        List<Game> games = gameService.findAll();
        List<GameMinDto> dtos = objectMapperUtil.map(games, List.class);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<List<GameMinDto>> findByList(@PathVariable Long id) {
        List<Game> games = gameService.findByList(id);
        List<GameMinDto> dtoList = games.stream().map(GameMinDto::new).toList();
        return ResponseEntity.ok(dtoList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GameDto> findById(@PathVariable Long id, @RequestBody GameDto gameDto) {
        Game game = objectMapperUtil.map(gameDto, Game.class);
        Game savedGame = gameService.update(id, game);
        GameDto dto = objectMapperUtil.map(savedGame, GameDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        // Chama o serviço para deletar o game pelo ID
        gameService.delete(id);

        // Retorna a resposta HTTP com uma mensagem de sucesso
        return ResponseEntity.status(HttpStatus.OK).body("Game deletado com sucesso!");
    }

}




