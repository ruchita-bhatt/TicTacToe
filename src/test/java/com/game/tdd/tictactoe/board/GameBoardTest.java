package com.game.tdd.tictactoe.board;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameBoardTest {

    @Autowired
    GameBoard gameBoard;

    @Test
    @DisplayName("Board should be initialize with the size of 9 and default values")
    void gameBoardShouldBeInitializeHavingSizeNineWithDefaultValues() {
        String[] expectedBoard = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

        gameBoard.initializeGameBoard();
        String[] board = gameBoard.getBoard();

        assertEquals(expectedBoard.length, board.length);
        assertArrayEquals(expectedBoard, board);
    }
}
