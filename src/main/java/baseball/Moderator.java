package baseball;

import baseball.ui.EndView;
import baseball.ui.InputView;
import baseball.ui.ResultView;

import java.util.ArrayList;

import static baseball.Constants.BALL_SIZE;
import static baseball.ui.EndView.getUserIntentionForRestart;

public class Moderator {

    public void startBaseball() {
        final Ball randomBall = generateRandomBall();
        Judge judge = new Judge(randomBall);
        int strikeCount = 0;
        int ballCount;

        while (strikeCount < 3) {
            // 사용자한테 볼 넘버 받기
            ArrayList<Integer> inputNumber = getUserInputNumber();
            Ball inputBall = new Ball(inputNumber);

            // 결과 구하기
            strikeCount = judge.getStrikeCount(inputBall);
            ballCount = judge.getBallCount(inputBall);

            // 출력하기
            ResultView.showResult(ballCount, strikeCount);
        }
    }

    public void endBaseball() {
        EndView.endGame();
    }

    public boolean isNeedToRestart() {
        return getUserIntentionForRestart();
    }

    private Ball generateRandomBall() {
        return new Ball(RandomNumberGenerator.generate(BALL_SIZE));
    }

    private ArrayList<Integer> getUserInputNumber() {
        return InputView.getUserBallNumber();
    }

}
