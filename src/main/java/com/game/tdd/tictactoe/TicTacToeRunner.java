package com.game.tdd.tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.game.tdd.tictactoe.constants.GameConstants.*;

@Profile("!test")
@Component
public class TicTacToeRunner implements ApplicationRunner {

    @Autowired
    TicTacToeGameExecutor tacToeGameExecutor;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String result = tacToeGameExecutor.startGame();
        System.out.println(result);
        System.out.println(GAME_OVER_MESSAGE);
    }
}
