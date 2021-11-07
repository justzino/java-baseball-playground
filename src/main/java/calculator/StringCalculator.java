package calculator;

import java.util.LinkedList;

public class StringCalculator {

    private String[] formula;
    private LinkedList<Double> operands;
    private LinkedList<String> operators;

    private double result;

    public StringCalculator() {
        this.operands = new LinkedList<>();
        this.operators = new LinkedList<>();
    }

    public double getResult() {
        return result;
    }

    public void setFormula(String s) {
        formula = s.split(" ");      // values 초기화
        if (formula.length < 3) {
            throw new IllegalArgumentException("3글자 이상 입력해 주세요.");
        }
        for (int i = 0; i < formula.length; i++) {
            validate(i, formula[i]);
            if (isDigit(formula[i])) {
                operands.add(Double.valueOf(formula[i]));
            }
            if (isOperator(formula[i])) {
                operators.add(formula[i]);
            }
        }
    }

    public void calculate() {
        result = operands.pop();
        while (!operands.isEmpty()) {
            double operand2 = operands.pop();
            calculateEach(result, operand2, operators.pop());
        }
    }

    private void calculateEach(double operand1, double operand2, String operator) {
        for (Operator op: Operator.values()) {
            if (operator.equals(op.getOperator())) {
                result = op.operate(operand1, operand2);
            }
        }
    }

    private void validate(int idx, String value) {
        if (idx % 2 == 0 && !isDigit(value)) {  // 짝수번째: 숫자가 와야함
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        if (idx % 2 == 1 && !isOperator(value)) {   // 홀수번째: operator 가 와야함
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private boolean isDigit(String value) {
        return value.matches("^0|[1-9]+[0-9]*");
    }

    private boolean isOperator(String value) {
        return value.matches("[+\\-*/]");
    }
}
