package baseball.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static baseball.Constants.EMPTY;
import static baseball.Constants.GET_USER_BALL_NUMBER_MESSAGE;

public class InputView {

    public static ArrayList<Integer> getUserBallNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(GET_USER_BALL_NUMBER_MESSAGE);
        String userInputString = scanner.nextLine();
        return convertStringListToIntList(new ArrayList<>(Arrays.asList(userInputString.split(EMPTY))));
    }

    private static ArrayList<Integer> convertStringListToIntList(ArrayList<String> strList) {
        ArrayList<Integer> integerList = new ArrayList<>();
        for (String s : strList) {
            addNumber(integerList, Integer.parseInt(s));
        }
        return integerList;
    }

    private static void addNumber(ArrayList<Integer> integerList, int number) {
        if (!isDuplicated(integerList, number)) {    // 이미 있는 값이면 다시 구하기
            integerList.add(number);
        }
    }

    private static boolean isDuplicated(ArrayList<Integer> randomNumber, int number) {
        return randomNumber.contains(number);
    }

}
