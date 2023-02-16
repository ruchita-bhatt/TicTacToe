package com.game.tdd.tictactoe.board;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

    @Test
    @DisplayName("Check for Position to be in board range")
    void positionInBoardRange() {
        int testPosition = 5;
        assertTrue(gameBoard.isPositionInRange(testPosition));
    }

    @ParameterizedTest
    @DisplayName("Check for multiple positions which are out of board range")
    @MethodSource("invalidPositionsProvider")
    void checkForMultiplePositionsOutOfBoardRange(int testPosition) {
        assertFalse(gameBoard.isPositionInRange(testPosition));
    }

    private static Stream<Arguments> invalidPositionsProvider() {
        return Stream.of(arguments(-1), arguments(9), arguments(11));
    }
}
