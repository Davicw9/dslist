package com.devsuperior.dslist.GameList.dto;

import com.devsuperior.dslist.GameList.entitie.GameList;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class GameListDto {
    private Long id;
    private String name;

    //Construtores
    public GameListDto() {

    }

    public GameListDto(GameList gameList) {
        BeanUtils.copyProperties(gameList, this);
    }

    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameListDto that = (GameListDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
