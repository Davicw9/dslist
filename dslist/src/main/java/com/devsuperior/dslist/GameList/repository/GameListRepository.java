package com.devsuperior.dslist.GameList.repository;

import com.devsuperior.dslist.GameList.entitie.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {

}
