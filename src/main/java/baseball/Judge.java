package baseball;

public class Judge {
    Ball givenNumber;     // 랜덤으로 생성한 볼 넘버

    public Judge(Ball givenNumber) {
        this.givenNumber = givenNumber;
    }

    private int getDuplicateNumberCount(Ball ball) {
        int nDuplicateNumber = 0;   // 중복된 숫자 갯수
        for (int i = 0; i < ball.size(); i++) {
            nDuplicateNumber += calculateDuplicateNumber(ball, i);
        }
        return nDuplicateNumber;
    }

    public int getStrikeCount(Ball ball) {
        int nStrike = 0;
        for (int i = 0; i < ball.size(); i++) {
            nStrike += calculateStrike(ball, i);
        }
        return nStrike;
    }

    public int getBallCount(Ball ball) {
        return getDuplicateNumberCount(ball) - getStrikeCount(ball);
    }

    private int calculateStrike(Ball ball, int index) {
        if (isStrike(ball, index)) return 1;
        return 0;
    }

    private int calculateDuplicateNumber(Ball ball, int index) {
        if (isDuplicateNumber(ball, index)) return 1;
        return 0;
    }

    private boolean isStrike(Ball ball, int index) {
        return givenNumber.get(index).equals(ball.get(index));
    }

    private boolean isDuplicateNumber(Ball ball, int index) {
        return givenNumber.contains(ball.get(index));
    }
}
