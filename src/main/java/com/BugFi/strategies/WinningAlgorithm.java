package com.BugFi.strategies;

import com.BugFi.models.Board;
import com.BugFi.models.Move;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WinningAlgorithm {
    Map<Integer, Map<Character, Integer>> rowMap;
    Map<Integer, Map<Character, Integer>> colMap;
    Map<Character, Integer> leftDiagMap = new HashMap<>();
    Map<Character, Integer> rightDiagMap = new HashMap<>();

    public WinningAlgorithm(int dimension) {
        rowMap = new HashMap<>();
        colMap = new HashMap<>();
        leftDiagMap = new HashMap<>();

        for (int i = 0; i < dimension; i++) {
            rowMap.put(i, new HashMap<>());
            colMap.put(i, new HashMap<>());
        }
    }

    public boolean addAndCheckWinningMove(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol().getCharacter();

        rowMap.get(row).put(symbol, rowMap.get(row).getOrDefault(symbol, 0) + 1);
        colMap.get(col).put(symbol, colMap.get(col).getOrDefault(symbol, 0) + 1);

        if (row == col) {
            leftDiagMap.put(symbol, leftDiagMap.getOrDefault(symbol, 0) + 1);
        }

        if (row + col == board.getSize() - 1) {
            rightDiagMap.put(symbol, rightDiagMap.getOrDefault(symbol, 0) + 1);
        }

        return Objects.equals(rowMap.get(row).get(symbol), board.getSize()) || Objects.equals(colMap.get(col).get(symbol), board.getSize()) || Objects.equals(leftDiagMap.get(symbol), board.getSize()) || Objects.equals(rightDiagMap.get(symbol), board.getSize());
    }
}
