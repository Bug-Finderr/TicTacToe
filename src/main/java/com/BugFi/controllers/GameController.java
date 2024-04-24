package com.BugFi.controllers;

import com.BugFi.exceptions.IllegalMoveException;
import com.BugFi.models.Game;
import com.BugFi.models.GameState;
import com.BugFi.models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players) {
        // Validate if 2 players have same symbol, if so, throw an exception
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(i).getSymbol() == players.get(j).getSymbol()) {
                    throw new IllegalArgumentException("Players cannot have the same symbol");
                }
            }
        }
        return new Game(dimension, players);
    }

    public void makeMove(Game game) throws IllegalMoveException {
        game.makeMove();
    }

    public GameState checkGameState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }
}
