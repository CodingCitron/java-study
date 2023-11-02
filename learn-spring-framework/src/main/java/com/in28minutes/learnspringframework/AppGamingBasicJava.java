package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;
import com.in28minutes.learnspringframework.game.MarioGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {

        var game = new PacmanGame();
//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var gameRunner = new GameRunner(game);

        gameRunner.run();
    }
}
