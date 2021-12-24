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
        for (String s : strList) integerList.add(Integer.valueOf(s));

        return integerList;
    }

}
