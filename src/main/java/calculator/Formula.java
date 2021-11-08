package calculator;

import java.util.LinkedList;

public class Formula {
    public LinkedList<Double> operands;
    public LinkedList<String> operators;

    public Formula() {
        this.operands = new LinkedList<>();
        this.operators = new LinkedList<>();
    }

    public double popOperand() {
        return operands.pop();
    }

    public String popOperator() {
        return operators.pop();
    }

    public void addOperandFirst(double operand) {
        operands.addFirst(operand);
    }

    public void set(String s) {
        String[] formula;
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

    public boolean isEmpty() {
        return operators.isEmpty();
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
