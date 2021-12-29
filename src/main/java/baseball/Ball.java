package baseball;

import java.util.Objects;

import static baseball.Constants.*;

public class Ball {
    private final int position;
    private final int ballNumber;

    public Ball(int position, int ballNumber) {
        validateBallNumber(ballNumber);
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public BallStatus compare(Ball ball) {
        if (this.equals(ball)) return BallStatus.STRIKE;
        if (matchBallNumber(ball.ballNumber)) return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    private boolean matchBallNumber(int ballNumber) {
        return this.ballNumber == ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNumber == ball.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNumber);
    }

    private void validateBallNumber(int number) {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException(BALL_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
