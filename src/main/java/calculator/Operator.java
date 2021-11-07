package calculator;

import java.util.function.BinaryOperator;

public enum Operator {
    // BinaryOperator 는 Lambda 표현식으로 구현할 수 있다.
    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
    DIVIDE("/", (operand1, operand2) -> operand1 / operand2);

    private String operator;
    private BinaryOperator<Double> operands;

    // 생성자
    Operator(String operator, BinaryOperator<Double> operands) {
        this.operator = operator;
        this.operands = operands;
    }

    public String getOperator() {
        return operator;
    }

    public double operate(double operand1, double operand2) {
        return operands.apply(operand1, operand2);
    }
}

