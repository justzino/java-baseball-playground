package calculator;

public class StringCalculator {

    private Formula formula;


    public StringCalculator() {
        this.formula = new Formula();
    }

    private void setFormula(String str) {
        formula.setFormula(str);
    }

    public double calculate(String str) {
        double result;
        setFormula(str);

        double operand1 = formula.getOperand();
        while (!formula.isEmpty()) {
            double operand2 = formula.getOperand();
            String nowOperator = formula.getOperator();
            for (Operator op : Operator.values()) {
                if (nowOperator.equals(op.getOperator())) {
                    operand1 = op.operate(operand1, operand2);
                }
            }
        }
        result = operand1;
        return result;
    }
}
