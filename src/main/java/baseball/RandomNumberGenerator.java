package baseball;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumberGenerator {

    public static ArrayList<Integer> generate(int length) {
        ArrayList<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < length) {
            int number = generateEach();
            addNumber(randomNumber, number);
        }
        return randomNumber;
    }

    private static int generateEach() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

    private static void addNumber(ArrayList<Integer> randomNumber, int number) {
        if (!isDuplicated(randomNumber, number)) {    // 이미 있는 값이면 다시 구하기
            randomNumber.add(number);
        }
    }

    private static boolean isDuplicated(ArrayList<Integer> randomNumber, int number) {
        return randomNumber.contains(number);
    }
}
