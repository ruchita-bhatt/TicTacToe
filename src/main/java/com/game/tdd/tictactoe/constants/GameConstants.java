package com.game.tdd.tictactoe.constants;

public class GameConstants {
    public static final int LOWER_BOUND = 0;
    public static final int UPPER_BOUND = 9;
    public static final int BOARD_LOWER_BOUND = 1;
    public static final int BOARD_UPPER_BOUND = 10;

    public static final String PLAYER_X = "X";
    public static final String PLAYER_O = "O";
    public static final String PLAYER_X_WINNING_PATTERN = "XXX";
    public static final String PLAYER_O_WINNING_PATTERN = "OOO";
    public static final String EMPTY_STRING = "";
    public static final String VALID_INPUT_PATTERN = "\\d";

    // Messages
    public static final String POSITION_NOT_IN_RANGE_MESSAGE = "Invalid Position. Please enter a value between 1 to 9";
    public static final String POSITION_IS_OCCUPIED_MESSAGE = "Position is already occupied, please select another position.";
    public static final String PLAYER_MESSAGE = "Player ";
    public static final String WINNER_MESSAGE = " wins the game";
    public static final String GAME_DRAW_MESSAGE = "Game is draw !!";
    public static final String GAME_OVER_MESSAGE = "Game Over !! ";
    public static final String MAKE_A_MOVE_MESSAGE = " please make a move";
    public static final String INVALID_INPUT_MESSAGE = "Invalid Input. Please enter one value between 1 to 9";
}
