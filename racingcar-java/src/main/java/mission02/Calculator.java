package mission02;

/**
 * 최종적인 계산기, main에 우겨 때려 넣을 수 없어서 팩토리 하나를 만듦
 */
public class Calculator {

    private final StringUtils stringUtils;
    private final Calculation calculation;

    public Calculator(String expression) {
        stringUtils = new StringUtils(expression);
        calculation = new Calculation();
    }

    public int getCalculatorValue(){
        String[] expressToken = stringUtils.getExpression();
        int base = stringUtils.getCharacterToNumber(expressToken[0]);

        for (int i=1 ; i < expressToken.length; i = i + 2){
            int nextOperand = stringUtils.getCharacterToNumber(expressToken[i+1]);
            base = calculation.splitCalculation(base, expressToken[i], nextOperand);
        }
        return base;
    }
}
