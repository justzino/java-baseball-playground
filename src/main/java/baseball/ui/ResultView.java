package baseball.ui;

import baseball.Constants;

public class ResultView {

    public static void showResult(int ballCount, int strikeCount) {
        if (ballCount > Constants.ZERO) {
            System.out.print(ballCount + Constants.BALL_MESSAGE + Constants.SPACE);
        }
        if (strikeCount > Constants.ZERO) {
            System.out.print(strikeCount + Constants.STRIKE_MESSAGE);
        }
        if (ballCount == Constants.ZERO && strikeCount == Constants.ZERO) {
            System.out.print(Constants.NOTHING_MESSAGE);
        }
        System.out.println();
    }
}
