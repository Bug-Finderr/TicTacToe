package com.BugFi.models;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private static Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        System.out.println(this.name + "'s turn");
        System.out.print("Enter row and column: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        return new Move(new Cell(row, col), this);
    }
}
