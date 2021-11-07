import calculator.StringCalculator;

public class CalculatorApp {
    public static void main(String[] args) {
        StringCalculator calculator1 = new StringCalculator();
        String formula = "2 + 3 * 4 / 2";
        calculator1.setFormula(formula);

        calculator1.calculate();
        System.out.println(calculator1.getResult());

    }
}
