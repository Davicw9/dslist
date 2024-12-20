package com.devsuperior.dslist.game.dto;

import com.devsuperior.dslist.game.entitie.Game;
import com.devsuperior.dslist.game.projection.GameMinProjection;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class GameMinDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;


    //CONSTRUTORES
    public GameMinDto() {}

    public GameMinDto(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.shortDescription = entity.getShortDescription();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
    }

    public GameMinDto(GameMinProjection projection) {
        this.id = projection.getId();
        this.title = projection.getTitle();
        this.shortDescription = projection.getShortDescription();
        this.year = projection.getGameYear();
        this.imgUrl = projection.getImgUrl();
    }

    //GETTERS

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Long getId() {
        return id;
    }
}
