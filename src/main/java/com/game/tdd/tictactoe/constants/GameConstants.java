package com.game.tdd.tictactoe.constants;

public class GameConstants {
    public static final int LOWER_BOUND = 0;
    public static final int UPPER_BOUND = 9;

    public static final String PLAYER_X = "X";
    public static final String PLAYER_O = "O";
    public static final String PLAYER_X_WINNING_PATTERN = "XXX";
    public static final String PLAYER_O_WINNING_PATTERN = "OOO";
    public static final String EMPTY_STRING = "";

    // Messages
    public static final String POSITION_NOT_IN_RANGE_MESSAGE = "Invalid Position. Please enter a value between 1 to 9";
    public static final String POSITION_IS_OCCUPIED_MESSAGE = "Position is already occupied, please select another position.";
    public static final String PLAYER_MESSAGE = "Player ";
    public static final String WINNER_MESSAGE = " wins the game";
    public static final String GAME_DRAW_MESSAGE = "Game is draw !!";
}
