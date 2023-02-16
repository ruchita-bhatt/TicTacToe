package com.game.tdd.tictactoe.board;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.game.tdd.tictactoe.exception.PositionIsOccupiedException;
import com.game.tdd.tictactoe.exception.PositionOutOfRangeException;

import static com.game.tdd.tictactoe.constants.TestGameConstants.*;

@SpringBootTest
public class PlayerActionTest {

    @Autowired
    private PlayerAction playerAction;

    @MockBean
    private GameBoard gameBoard;

    @Test
    @DisplayName("Game should throw exeption if Position is not in board range")
    void throwExceptionIfPositionNotInRange() {
        int position = INVALID_POSITIVE_POSITION_ELEVEN;
        when(gameBoard.isPositionInRange(anyInt())).thenReturn(false);
        assertThrows(PositionOutOfRangeException.class, () -> playerAction.placePlayerMove(position));
    }

    @Test
    @DisplayName("Game should throw exeption if Position is already occupied")
    void throwExceptionIfPositionIsOccupied() {
        int position = VALID_POSITION_SIX;
        when(gameBoard.isPositionInRange(anyInt())).thenReturn(true);
        when(gameBoard.getBoard()).thenReturn(new String[] { "1", "2", "3", "4", "5", "X", "7", "8", "9" });

        assertThrows(PositionIsOccupiedException.class, () -> playerAction.placePlayerMove(position));
    }

    @Test
    @DisplayName("Place the move by updating board without any exception")
    void placeTheMoveWithoutException() {
        int position = VALID_POSITION_FIVE;
        when(gameBoard.isPositionInRange(anyInt())).thenReturn(true);
        when(gameBoard.getBoard()).thenReturn(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" });

        assertDoesNotThrow(() -> playerAction.placePlayerMove(position));
        assertEquals(PLAYER_O, gameBoard.getBoard()[position - 1]);
    }

    @Test
    @DisplayName("Should update the next Player based on current move")
    void shouldUpdateNextPlayer() throws PositionOutOfRangeException, PositionIsOccupiedException {
        int position = VALID_POSITION_FIVE;
        when(gameBoard.isPositionInRange(anyInt())).thenReturn(true);
        when(gameBoard.getBoard()).thenReturn(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" });

        playerAction.placePlayerMove(position);
        assertEquals(PLAYER_O, playerAction.getNextPlayer());
    }
}
