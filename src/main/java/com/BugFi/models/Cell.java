package com.BugFi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private Integer row;
    private Integer col;
    private CellState cellState;
    private Player player;

    public Cell(Integer row, Integer col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }
}
