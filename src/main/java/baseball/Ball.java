package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static baseball.Constants.*;

public class Ball {

    private final List<Integer> ballNumber;

    public Ball(ArrayList<Integer> chanceNumber) {
        validateSize(chanceNumber);
        validateNumber(chanceNumber);
        validateDuplicate(chanceNumber);
        this.ballNumber = chanceNumber;
    }

    public Integer get(int i) {
        return this.ballNumber.get(i);
    }

    public boolean contains(int i) {
        return this.ballNumber.contains(i);
    }

    public int size() {
        return ballNumber.size();
    }

    private void validateSize(ArrayList<Integer> ballNumber) {
        if (ballNumber.size() != BALL_SIZE) {
            throw new IllegalArgumentException(BALL_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void validateNumber(ArrayList<Integer> ballNumber) {
        for (int number : ballNumber) {
            checkNumber(number);
        }
    }

    private void validateDuplicate(ArrayList<Integer> ballNumber) {
        for (int number : ballNumber) {
            checkDuplicate(number);
        }
    }

    private void checkNumber(int number) {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException(BALL_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void checkDuplicate(int number) {
        if (Collections.frequency(ballNumber, number) > 1) {
            throw new IllegalArgumentException(BALL_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }
}
