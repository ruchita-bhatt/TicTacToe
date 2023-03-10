package com.game.tdd.tictactoe;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.game.tdd.tictactoe.exception.InvalidInputException;

import static com.game.tdd.tictactoe.constants.TestGameConstants.*;

@ActiveProfiles("test")
@SpringBootTest
class TicTacToeGameExecutorTest {

	@Autowired
	private TicTacToeGameExecutor ticTacToeGameExecutor;

	@ParameterizedTest
	@DisplayName("Check for multiple positions which are out of board range")
	@MethodSource("invalidUserInput")
	void shouldThrowInputMismatchException(String userInput) {
		assertThrows(InvalidInputException.class, () -> ticTacToeGameExecutor.validateUserInput(userInput));
	}

	@Test
	@DisplayName("Should return player X wining message using multiple inputs")
	void shouldReturnPlayerXWinningMessage() {
		StringBuilder userInputBuilder = new StringBuilder("1").append(LINE_BREAK)
				.append("2").append(LINE_BREAK).append("5").append(LINE_BREAK).append("3").append(LINE_BREAK)
				.append("9");
		System.setIn(new ByteArrayInputStream(userInputBuilder.toString().getBytes()));
		assertEquals(PLAYER_X_WINNING_MESSAGE, ticTacToeGameExecutor.startGame());
	}

	@Test
	@DisplayName("Should return player O winning message using multiple inputs")
	void shouldReturnPlayerOWinningMessage() {
		StringBuilder userInputBuilder = new StringBuilder("1").append(LINE_BREAK)
				.append("2").append(LINE_BREAK).append("3").append(LINE_BREAK).append("4").append(LINE_BREAK)
				.append("6").append(LINE_BREAK)
				.append("5").append(LINE_BREAK).append("7").append(LINE_BREAK).append("8").append(LINE_BREAK)
				.append("9");
		System.setIn(new ByteArrayInputStream(userInputBuilder.toString().getBytes()));
		assertEquals(PLAYER_O_WINNING_MESSAGE, ticTacToeGameExecutor.startGame());
	}

	@Test
	@DisplayName("Should return game draw message using multiple inputs")
	void shouldReturnGameDrawMessage() {
		StringBuilder userInputBuilder = new StringBuilder("1").append(LINE_BREAK)
				.append("2").append(LINE_BREAK).append("3").append(LINE_BREAK).append("4").append(LINE_BREAK)
				.append("6").append(LINE_BREAK)
				.append("5").append(LINE_BREAK).append("7").append(LINE_BREAK).append("9").append(LINE_BREAK)
				.append("8");
		System.setIn(new ByteArrayInputStream(userInputBuilder.toString().getBytes()));
		assertEquals(GAME_DRAW_MESSAGE, ticTacToeGameExecutor.startGame());
	}

	private static Stream<Arguments> invalidUserInput() {
		return Stream.of(arguments(INVALID_NEGATIVE_NUMBER), arguments(INVALID_NUMERIC_USER_INPUT),
				arguments(INVALID_NUMERIC_WITH_SPACES), arguments(INVALID_NUMERIC_WITH_SECIAL_CHARACTER),
				arguments(INVALID_ALPHA_NUMERIC),
				arguments(INVALID_STRING_WITH_SPECIAL_CHARACTER));
	}
}
