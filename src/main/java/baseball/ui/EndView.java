package baseball.ui;

import java.util.Scanner;

import static baseball.Constants.*;

public class EndView {

    public static void endGame() {
        System.out.println(END_GAME_SUCCESS_MESSAGE);
    }

    public static boolean getUserIntentionForRestart() {
        int newGameSelector = getUserGameSelector();
        while (!isAvailableNewGameSelector(newGameSelector)) {
            newGameSelector = getUserGameSelector();
        }
        return newGameSelector == NEW_GAME_SELECTOR;
    }

    private static boolean isAvailableNewGameSelector(int gameSelector) {
        return gameSelector == NEW_GAME_SELECTOR || gameSelector == END_GAME_SELECTOR;
    }

    private static int getUserGameSelector() {
        System.out.println(GET_USER_GAME_SELECTOR_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
