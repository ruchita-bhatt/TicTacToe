package com.game.tdd.tictactoe.board;

import org.springframework.stereotype.Component;

import static com.game.tdd.tictactoe.constants.GameConstants.*;

import java.util.Arrays;
import java.util.stream.IntStream;

@Component
public class GameBoard {
    private String[] board;

    public void initializeGameBoard() {
        board = new String[UPPER_BOUND];
        IntStream.range(BOARD_LOWER_BOUND, BOARD_UPPER_BOUND)
                .forEach((index) -> board[index - 1] = String.valueOf(index));
    }

    public String[] getBoard() {
        return board;
    }

    public boolean isPositionInRange(int position) {
        return position >= LOWER_BOUND && position < UPPER_BOUND;
    }

    public boolean checkForWinner() {
        boolean isWinnerFound = false;
        for (int i = LOWER_BOUND; i < UPPER_BOUND; i++) {
            String line = "";
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals(PLAYER_X_WINNING_PATTERN) || line.equals(PLAYER_O_WINNING_PATTERN)) {
                isWinnerFound = true;
                break;
            }
        }

        return isWinnerFound;
    }

    public boolean checkForDraw() {
        return Arrays.asList(board).stream()
                .allMatch(element -> element.equals(PLAYER_O) || element.equals(PLAYER_X));
    }

    public void displayBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }
}
