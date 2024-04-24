package com.BugFi.models;

import java.util.List;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println(this.getName() + "'s turn");
        if (botDifficultyLevel == BotDifficultyLevel.EASY) {
            return makeEasyMove(board);
        } else if (botDifficultyLevel == BotDifficultyLevel.MEDIUM) {
            return makeMediumMove(board);
        } else {
            return makeHardMove(board);
        }
    }

    private Move makeMediumMove(Board board) {
        // Implement the medium difficulty level logic here
        return null;
    }

    private Move makeHardMove(Board board) {
        // Implement the hard difficulty level logic here
        return null;
    }

    private Move makeEasyMove(Board board) {
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState() == CellState.EMPTY) {
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}
