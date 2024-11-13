package com.devsuperior.dslist.game.repository;

import com.devsuperior.dslist.game.entitie.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
