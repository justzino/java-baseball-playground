package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball computerBall;

    @BeforeEach
    void setUp() {
        computerBall = new Ball(1, 4);
    }

    @Test
    void Ball() {
        BallStatus ballStatus = computerBall.compare(new Ball(2, 4));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void Strike() {
        BallStatus ballStatus = computerBall.compare(new Ball(1, 4));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void Nothing() {
        BallStatus ballStatus = computerBall.compare(new Ball(2, 5));
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
