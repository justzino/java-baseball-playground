import calculator.StringCalculator;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        StringCalculator calculator1 = new StringCalculator();
        Scanner sc = new Scanner(System.in);

        String formula = sc.nextLine();
        System.out.println(calculator1.calculate(formula));
    }
}
