package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class MainController {
    private static final char RESTART = '1';
    private static final char END_GAME = '2';
    GameController gameController;

    public MainController() {
        gameController = new GameController();
    }

    public void startProgram() {
        boolean isRunning = true;

        OutputView.printProgramMessage();
        do {
            gameController.startGame();

            String whetherRestart = InputController.scanWhetherRestart();
            if(whetherRestart.charAt(0) == END_GAME) {
                isRunning = false;
            }
        } while(isRunning);
    }

    private static class InputController {
        private static final String WRONG_INPUT_WHETHER_RESTART_MESSAGE = "1 또는 2를 입력해주세요.";

        public static String scanWhetherRestart() {
            InputView.printEnterWhetherRestart();
            String inputString = Console.readLine();
            validateWhetherRestart(inputString);
            return inputString;
        }

        private static void validateWhetherRestart(String inputString) {
            if (inputString.length() != 1) throw new IllegalArgumentException(WRONG_INPUT_WHETHER_RESTART_MESSAGE);
            else if (inputString.charAt(0) != RESTART && inputString.charAt(0) != END_GAME)
                throw new IllegalArgumentException(WRONG_INPUT_WHETHER_RESTART_MESSAGE);
        }
    }
}
