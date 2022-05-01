package step2;

public final class StringCalculator extends ArithmeticCalculator {

    private final static String[] operators = {"+", "-", "*", "/"};

    public int calculation(final String str) {
        if (str == null || str == "") throw new IllegalArgumentException();

        String[] input = str.split(" ");
        String operator = null;
        int result = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i++) {
            if (isOperator(input[i])) {
                operator = input[i];
            } else {
                int x = Integer.parseInt(input[i - 2]);
                int y = Integer.parseInt(input[i]);
                result = selectArithmeticOperation(operator, result, y);
            }
        }

        return result;
    }

    private final boolean isOperator(final String str) {
        for (String operator : operators) {
            if (operator.equals(str)) return true;
        }
        return false;
    }

    public int selectArithmeticOperation(final String operator, final int x,final int y) {
        int answer = 0;
        switch (operator) {
            case "+":
                answer = this.add(x,y);
                break;
            case "*":
                answer = this.multiplication(x,y);
                break;
            case "-":
                answer = this.minus(x,y);
                break;
            case "/":
                answer = this.division(x,y);
                break;
        }
        return answer;
    }

}