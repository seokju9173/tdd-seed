package mission02;

import mission02.exception.DividedException;
import mission02.exception.OperatorException;

/**
 * 나눠진 문자열을 받아 연산을 연산 기호를 받아, 문자열을 연산해주는 클래스
 */
public class Calculation {

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDED = "/";

    private static final int ZERO = 0;

    public int calculate(int baseOperand, String operator, int nextOperand){
        switch (operator) {
            case PLUS:
                return plusNumber(baseOperand, nextOperand);
            case MINUS:
                return minusNumber(baseOperand, nextOperand);
            case MULTIPLY:
                return multiNumber(baseOperand, nextOperand);
            case DIVIDED:
                return divNumber(baseOperand, nextOperand);
            default:
                throw new OperatorException();
        }
    }

    private int plusNumber(int baseOperand, int nextOperand){
        return Math.addExact(baseOperand, nextOperand);
    }

    private int minusNumber(int baseOperand, int nextOperand){
        return Math.subtractExact(baseOperand,nextOperand);
    }

    private int multiNumber(int baseOperand, int nextOperand){
        return Math.multiplyExact(baseOperand, nextOperand);
    }

    private int divNumber(int baseOperand, int nextOperand){
        canDividedNumber(nextOperand);
        return Math.floorDiv(baseOperand,nextOperand);
    }

    private void canDividedNumber(int operand){
        if (operand == ZERO){
            throw new DividedException();
        }
    }
}