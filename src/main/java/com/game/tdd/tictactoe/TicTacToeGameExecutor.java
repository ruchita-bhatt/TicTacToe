package com.game.tdd.tictactoe;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.game.tdd.tictactoe.board.PlayerAction;
import com.game.tdd.tictactoe.exception.InvalidInputException;
import com.game.tdd.tictactoe.exception.PositionIsOccupiedException;
import com.game.tdd.tictactoe.exception.PositionOutOfRangeException;

import static com.game.tdd.tictactoe.constants.GameConstants.*;

@Component
public class TicTacToeGameExecutor {

    @Autowired
    private PlayerAction playerAction;

    public String startGame() {
        Scanner scanner = new Scanner(System.in);
        playerAction.initializeGameBoard();
        String result = EMPTY_STRING;
        while (result.isEmpty()) {
            playerAction.displayBoard();
            try {
                System.out.println(PLAYER_MESSAGE + playerAction.getNextPlayer() + MAKE_A_MOVE_MESSAGE);
                String input = scanner.nextLine();
                validateUserInput(input);
                result = playerAction.placePlayerMove(Integer.parseInt(input));
            } catch (PositionOutOfRangeException | PositionIsOccupiedException | InvalidInputException exception) {
                System.out.println(exception.getMessage());
            }
        }
        scanner.close();
        playerAction.displayBoard();
        return result;
    }

    public void validateUserInput(String input) throws InvalidInputException {
        if (!input.matches("\\d"))
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
    }
}
