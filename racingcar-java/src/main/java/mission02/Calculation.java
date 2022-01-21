package mission02;

/**
 * 나눠진 문자열을 받아 연산을 연산 기호를 받아, 문자열을 연산해주는 클래스
 */
public class Calculation {

    public int splitCalculation(int baseOperand, String operator, int nextOperand){
        switch (operator){
            case OperatorType.PLUS:
                return plusNumber(baseOperand, nextOperand);
            case OperatorType.MINUS:
                return minusNumber(baseOperand, nextOperand);
            case OperatorType.MULTIPLY:
                return multiNumber(baseOperand, nextOperand);
            case OperatorType.DIVIDED:
                return divNumber(baseOperand, nextOperand);
            default:
                throw new IllegalArgumentException("operation is not arithmetic operation");
        }
    }

    private void canDividedNumber(int operand){
        if (operand == 0){
            throw new IllegalArgumentException("cannot be divided by zero"); // ArithmeticException
        }
    }

    private int plusNumber(int baseOperand, int nextOperand){ return baseOperand + nextOperand; }

    private int minusNumber(int baseOperand, int nextOperand){ return baseOperand - nextOperand; }

    private int multiNumber(int baseOperand, int nextOperand){ return baseOperand * nextOperand; }

    private int divNumber(int baseOperand, int nextOperand){
        canDividedNumber(nextOperand); // divNumber 안에 넣어야 할지 아니면 case문에 넣는게 맞는지, divNumber안에 넣을지?
        return baseOperand / nextOperand;
    }
}