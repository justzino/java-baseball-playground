package calculator;

public class StringCalculator {

    private Formula formula;

    public StringCalculator() {
        this.formula = new Formula();
    }

    private void setFormula(String str) {
        formula.set(str);
    }

    public double calculate(String str) {
        double result;
        setFormula(str);

        while (!formula.isEmpty()) {
            calculateEach(formula);
        }
        result = formula.popOperand();
        return result;
    }

    private void calculateEach(Formula formula) {
        double operand1 = formula.popOperand();
        double operand2 = formula.popOperand();
        String operatorStr = formula.popOperator();
        Operator operator = Operator.findOperator(operatorStr);

        formula.addOperandFirst(operator.operate(operand1, operand2));    // 결과값을 다음 operand 로 쓰기 위해 다시 넣기.
    }
}
