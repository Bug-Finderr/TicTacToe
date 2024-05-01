package com.BugFi.models;

import com.BugFi.exceptions.IllegalMoveException;
import com.BugFi.strategies.WinningAlgorithm;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private Integer nextPlayerIndex;
    private WinningAlgorithm winningAlgorithm;

    public Game(int dimension, List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerIndex = 0;
        this.winningAlgorithm = new WinningAlgorithm(dimension);
    }

    public void printBoard() {
        this.board.printBoard();
    }

    public void makeMove() throws IllegalMoveException {
        Player currentPlayer = this.players.get(this.nextPlayerIndex);
        Move move = currentPlayer.makeMove(this.board);

        // Edge case: null returned from Bot means board completely filled
        if (move == null) {
            this.gameState = GameState.DRAW;
            return;
        }

        // Validate if the cell is already occupied
        if (!validateMove(move)) throw new IllegalMoveException("Cell is already occupied");
        this.moves.add(move);

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cellToUpdate = this.board.getBoard().get(row).get(col);
        cellToUpdate.setPlayer(currentPlayer);
        cellToUpdate.setCellState(CellState.OCCUPIED);
        Move currentMove = new Move(cellToUpdate, currentPlayer);
        moves.add(currentMove);

        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

        // Check if currentMove is winning move
        if (winningAlgorithm.addAndCheckWinningMove(this.board, currentMove)) {
            this.gameState = GameState.ENDED;
            this.winner = currentPlayer;
        }
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        return row >= 0 && row < this.board.getSize() && col >= 0 && col < this.board.getSize() && this.board.getBoard().get(row).get(col).getCellState() == CellState.EMPTY;
    }
}
