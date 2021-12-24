package baseball;

public class Constants {
    public static final int ZERO = 0;
    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 9;
    public static final int BALL_SIZE = 3;
    public static final int GAME_CHANCE = 3;
    public static final int NEW_GAME_SELECTOR = 1;
    public static final int END_GAME_SELECTOR = 2;

    public static final String SPACE = " ";
    public static final String EMPTY = "";

    public static final String BALL_MESSAGE = "볼";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String NOTHING_MESSAGE = "Nothing";

    public static final String GET_USER_BALL_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    public static final String END_GAME_SUCCESS_MESSAGE =
            String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", BALL_SIZE);
    public static final String GET_USER_GAME_SELECTOR_MESSAGE =
            String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", NEW_GAME_SELECTOR, END_GAME_SELECTOR);

    public static final String BALL_SIZE_EXCEPTION_MESSAGE =
            String.format("숫자는 %d자리만 가능합니다.", BALL_SIZE);
    public static final String BALL_NUMBER_EXCEPTION_MESSAGE =
            String.format("숫자는 %d부터 %d까지만 가능합니다.", MIN_BALL_NUMBER, MAX_BALL_NUMBER);
    public static final String BALL_DUPLICATE_EXCEPTION_MESSAGE = "서로 다른 숫자만 가능합니다.";
}
