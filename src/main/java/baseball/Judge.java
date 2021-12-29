package baseball;

public class Judge {
    Balls givenNumber;     // 랜덤으로 생성한 볼 넘버

    public Judge(Balls givenNumber) {
        this.givenNumber = givenNumber;
    }

    private int getDuplicateNumberCount(Balls balls) {
        int nDuplicateNumber = 0;   // 중복된 숫자 갯수
        for (int i = 0; i < balls.size(); i++) {
            nDuplicateNumber += calculateDuplicateNumber(balls, i);
        }
        return nDuplicateNumber;
    }

    public int getStrikeCount(Balls balls) {
        int nStrike = 0;
        for (int i = 0; i < balls.size(); i++) {
            nStrike += calculateStrike(balls, i);
        }
        return nStrike;
    }

    public int getBallCount(Balls balls) {
        return getDuplicateNumberCount(balls) - getStrikeCount(balls);
    }

    private int calculateStrike(Balls balls, int index) {
        if (isStrike(balls, index)) return 1;
        return 0;
    }

    private int calculateDuplicateNumber(Balls balls, int index) {
        if (isDuplicateNumber(balls, index)) return 1;
        return 0;
    }

    private boolean isStrike(Balls balls, int index) {
        return givenNumber.get(index).equals(balls.get(index));
    }

    private boolean isDuplicateNumber(Balls balls, int index) {
        return givenNumber.contains(balls.get(index));
    }
}
