package mission02;

import mission02.exception.FormatException;
import mission02.exception.InvalidExpressionException;

import java.util.StringTokenizer;

/**
 * 최종적인 계산기, main에 우겨 때려 넣을 수 없어서 팩토리 하나를 만듦
 */
public class Calculator {

    private static final String SPLIT_VAL = " ";
    private static final int ODD = 1;

    private final Calculation calculation = new Calculation();

    public int calculatorValue(String expression) {
        StringTokenizer expressionToken = new StringTokenizer(expression, SPLIT_VAL);
        int base = stringToInteger(expressionToken.nextToken());

        if (isTokenEven(expressionToken.countTokens() - 1)) {
            throw new InvalidExpressionException();
        }

        while (expressionToken.hasMoreTokens()) {
            String operator = expressionToken.nextToken();
            int nextOperand = stringToInteger(expressionToken.nextToken());
            base = calculation.calculate(base, operator, nextOperand);
        }
        return base;
    }

    private boolean isTokenEven(int expressionTokenSize) {
        return (expressionTokenSize & ODD) != ODD;
    }

    private int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new FormatException();
        }
    }
}