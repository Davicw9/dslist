package com.devsuperior.dslist.belonging;

import com.devsuperior.dslist.GameList.entitie.GameList;
import com.devsuperior.dslist.game.entitie.Game;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPk id = new BelongingPk();

    private int position;

    //Construtores
    public Belonging (){

    }

    public Belonging(Game game, GameList list, int position) {
        this.id.setGame(game);
        this.id.setGameList(list);
        this.position = position;
    }

    //Getters and Setters

    public BelongingPk getId() {
        return id;
    }

    public void setId(BelongingPk id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    //Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return position == belonging.position && Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position);
    }
}
