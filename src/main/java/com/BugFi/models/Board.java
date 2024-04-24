package com.BugFi.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
public class Board {
    private Integer size;
    private List<List<Cell>> board;

    public Board(Integer size) {
        this.size = size;
        this.board = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Cell(i, j));
            }
            board.add(row);
        }
    }

    public void printBoard() {
        System.out.println();
        for (List<Cell> row : board) {
            for (Cell cell : row) {
                if (cell.getCellState() == CellState.EMPTY) {
                    System.out.print("| - |");
                } else {
                    System.out.print("| " + cell.getPlayer().getSymbol().getCharacter() + " |");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
