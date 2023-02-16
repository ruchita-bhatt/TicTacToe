package com.game.tdd.tictactoe.board;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static com.game.tdd.tictactoe.constants.TestGameConstants.*;

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
        assertTrue(gameBoard.isPositionInRange(VALID_POSITION_FIVE));
    }

    @ParameterizedTest
    @DisplayName("Check for multiple positions which are out of board range")
    @MethodSource("invalidPositionsProvider")
    void checkForMultiplePositionsOutOfBoardRange(int testPosition) {
        assertFalse(gameBoard.isPositionInRange(testPosition));
    }

    @Test
    @DisplayName("when no winner found should return false")
    public void shouldReturnFalseIfNoWinnerFound() {
        gameBoard.initializeGameBoard();
        gameBoard.getBoard();

        assertFalse(gameBoard.checkForWinner());
    }

    @Test
    @DisplayName("Return true when Player win by following same row")
    public void shouldReturnTrueIfPlayerFollowSameRow() {
        int[] positions = new int[] { 3, 4, 5 };
        initializeBoardWithMoves(positions);

        assertTrue(gameBoard.checkForWinner());
    }

    @Test
    @DisplayName("Return true when Player win by folwing same column")
    public void shouldReturnTrueIfPlayerFollowSameColumn() {
        int[] positions = new int[] { 2, 5, 8 };
        initializeBoardWithMoves(positions);

        assertTrue(gameBoard.checkForWinner());
    }

    @Test
    @DisplayName("Return true when Player win by folwing same diagonal")
    public void shouldReturnTrueIfPlayerFollowSameDiagonal() {
        int[] positions = new int[] { 0, 4, 8 };
        initializeBoardWithMoves(positions);

        assertTrue(gameBoard.checkForWinner());
    }

    private static Stream<Arguments> invalidPositionsProvider() {
        return Stream.of(arguments(INVALID_NEGATIVE_POSITION), arguments(
                INVALID_POSITIVE_POSITION_NINE), arguments(INVALID_POSITIVE_POSITION_ELEVEN));
    }

    private void initializeBoardWithMoves(int[] positions) {
        gameBoard.initializeGameBoard();
        String[] board = gameBoard.getBoard();
        for (int index = 0; index < positions.length; index++) {
            board[positions[index]] = PLAYER_X;
        }
    }
}
