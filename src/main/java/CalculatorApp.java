import calculator.StringCalculator;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        StringCalculator calculator1 = new StringCalculator();
        Scanner sc = new Scanner(System.in);

        String formula = sc.nextLine();
        calculator1.setFormula(formula);
        calculator1.calculate();
        System.out.println(calculator1.getResult());
    }
}
