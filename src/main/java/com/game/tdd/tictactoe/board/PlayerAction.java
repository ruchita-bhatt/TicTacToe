package com.game.tdd.tictactoe.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.game.tdd.tictactoe.exception.PositionIsOccupiedException;
import com.game.tdd.tictactoe.exception.PositionOutOfRangeException;

import static com.game.tdd.tictactoe.constants.GameConstants.*;

@Component
public class PlayerAction {

    private String currentPlayer;

    @Autowired
    private GameBoard gameBoard;

    public String placePlayerMove(int position) throws PositionOutOfRangeException, PositionIsOccupiedException {
        position--;
        if (gameBoard.isPositionInRange(position)) {
            return performActionToHandleNextMove(position);
        } else {
            throw new PositionOutOfRangeException(POSITION_NOT_IN_RANGE_MESSAGE);
        }
    }

    private String performActionToHandleNextMove(int position) throws PositionIsOccupiedException {
        if (gameBoard.getBoard()[position].equals(PLAYER_O) || gameBoard.getBoard()[position].equals(PLAYER_X)) {
            throw new PositionIsOccupiedException(POSITION_IS_OCCUPIED_MESSAGE);
        } else {
            updateBoardWithMove(position);
        }
        return checkForWinnerAndDraw();
    }

    private void updateBoardWithMove(int position) {
        currentPlayer = getNextPlayer();
        gameBoard.getBoard()[position] = currentPlayer;
    }

    public String getNextPlayer() {
        return currentPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
    }

    private String checkForWinnerAndDraw() {
        if (gameBoard.checkForWinner()) {
            return PLAYER_MESSAGE + currentPlayer + WINNER_MESSAGE;
        } else if (gameBoard.checkForDraw()) {
            return GAME_DRAW_MESSAGE;
        }
        return EMPTY_STRING;
    }

    public void initializeGameBoard() {
        gameBoard.initializeGameBoard();
    }

    public void displayBoard() {
        gameBoard.displayBoard();
    }
}