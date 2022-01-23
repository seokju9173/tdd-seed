package mission02;

import mission02.exception.FormatException;
import mission02.exception.InvalidExpressionException;

/**
 * 최종적인 계산기, main에 우겨 때려 넣을 수 없어서 팩토리 하나를 만듦
 */
public class Calculator {

    private final Calculation calculation = new Calculation();

    private static final String SPLIT_VAL = " ";
    private static final int ODD = 1;

    public int calculatorValue(String expression){
        String[] expressionToken = getExpression(expression);
        int base = stringToInteger(expressionToken[0]);

        if (isTokenEven(expressionToken.length))
            throw new InvalidExpressionException();

        for (int i=1 ; i < expressionToken.length; i = i + 2){
            int nextOperand = stringToInteger(expressionToken[i+1]);
            base = calculation.calculate(base, expressionToken[i], nextOperand);
        }
        return base;
    }

    private boolean isTokenEven(int expressionTokenSize){
        return (expressionTokenSize & ODD) != ODD;
    }

    private String[] getExpression(String expression){
        return expression.split(SPLIT_VAL);
    }

    private int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new FormatException();
        }
    }
}
