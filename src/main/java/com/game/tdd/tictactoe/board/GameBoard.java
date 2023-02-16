package com.game.tdd.tictactoe.board;

import org.springframework.stereotype.Component;

import static com.game.tdd.tictactoe.constants.GameConstants.*;

@Component
public class GameBoard {
    private String[] board;

    public void initializeGameBoard() {
        board = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    }

    public String[] getBoard() {
        return board;
    }

    public boolean isPositionInRange(int position) {
        return position >= LOWER_BOUND && position < UPPER_BOUND;
    }
}
