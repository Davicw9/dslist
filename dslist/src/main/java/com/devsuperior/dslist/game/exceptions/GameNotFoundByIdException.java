package com.devsuperior.dslist.game.exceptions;

public class GameNotFoundByIdException extends RuntimeException {
    public GameNotFoundByIdException(String message) {
        super(message);
    }
}
