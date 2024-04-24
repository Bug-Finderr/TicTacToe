package com.BugFi;

import com.BugFi.controllers.GameController;
import com.BugFi.exceptions.IllegalMoveException;
import com.BugFi.models.*;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IllegalMoveException {
        GameController gameController = new GameController();

        List<Player> players = List.of(
                new Player("Player 1", new Symbol('X'), PlayerType.HUMAN),
                new Bot("Player 2 (Bot)", new Symbol('O'), PlayerType.BOT, BotDifficultyLevel.EASY)
        );

        Game game = gameController.startGame(3, players);

        while (game.getGameState() == GameState.IN_PROGRESS) {
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        gameController.printBoard(game);

        if (game.getGameState() != GameState.ENDED ) {
            game.setGameState(GameState.DRAW);
            System.out.println("It's a draw!");
        } else {
            System.out.println(game.getWinner().getName() + " wins!");
        }
    }
}