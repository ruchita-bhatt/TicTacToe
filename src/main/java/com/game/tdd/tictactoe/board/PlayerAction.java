package com.game.tdd.tictactoe.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.game.tdd.tictactoe.exception.PositionIsOccupiedException;
import com.game.tdd.tictactoe.exception.PositionOutOfRangeException;

@Component
public class PlayerAction {

    private final String PLAYER_X = "X";
    private final String PLAYER_O = "O";

    private String currentPlayer;

    @Autowired
    private GameBoard gameBoard;

    public void placePlayerMove(int position) throws PositionOutOfRangeException, PositionIsOccupiedException {
        position--;
        if (gameBoard.isPositionInRange(position)) {
            performActionToHandleNextMove(position);
        } else {
            throw new PositionOutOfRangeException("Please enter a value between 1 to 9");
        }
    }

    private void performActionToHandleNextMove(int position) throws PositionIsOccupiedException {
        if (gameBoard.getBoard()[position].equals("O") || gameBoard.getBoard()[position].equals("X")) {
            throw new PositionIsOccupiedException("Position is already occupied, please select another position.");
        } else {
            updateBoardWithMove(position);
        }
    }

    public void updateBoardWithMove(int position) {
        currentPlayer = getNextPlayer();
        gameBoard.getBoard()[position] = currentPlayer;
    }

    public String getNextPlayer() {
        return currentPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
    }
}