package baseball;

import baseball.ui.EndView;
import baseball.ui.InputView;
import baseball.ui.ResultView;

import java.util.ArrayList;

import static baseball.Constants.BALL_SIZE;
import static baseball.ui.EndView.getUserIntentionForRestart;

public class Moderator {

    public void startBaseball() {
        final Balls randomBalls = generateRandomBall();
        Judge judge = new Judge(randomBalls);
        int strikeCount = 0;
        int ballCount;

        while (strikeCount < 3) {
            // 사용자한테 볼 넘버 받기
            ArrayList<Integer> inputNumber = getUserInputNumber();
            Balls inputBalls = new Balls(inputNumber);

            // 결과 구하기
            strikeCount = judge.getStrikeCount(inputBalls);
            ballCount = judge.getBallCount(inputBalls);

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

    private Balls generateRandomBall() {
        return new Balls(RandomNumberGenerator.generate(BALL_SIZE));
    }

    private ArrayList<Integer> getUserInputNumber() {
        return InputView.getUserBallNumber();
    }

}
