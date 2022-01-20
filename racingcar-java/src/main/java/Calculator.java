public class Calculator {

    int calculate(String input) {
        checkNullOrEmpty(input);

        String[] data = input.split(" ");
        checkInputLength(data);
        
        int result = Integer.parseInt(data[0]);

        for (int i = 1; i < data.length; i += 2) {
            checkValidOperator(data[i]);
            String operator = data[i];

            int num = Integer.parseInt(data[i+1]);

            if (operator.equals("+")) {
                result = plus(result, num);
            } else if (operator.equals("*")) {
                result = multiply(result, num);
            } else if (operator.equals("-")) {
                result = minus(result, num);
            } else if (operator.equals("/")) {
                result = divide(result, num);
            }

        }
        return result;
    }

    private int divide(int result, int num) {
        if (num == 0) {
            throw new IllegalArgumentException("0으로는 나눌 수 없습니다");
        }
        result /= num;
        return result;
    }

    private int minus(int result, int num) {
        result -= num;
        return result;
    }

    private int multiply(int result, int num) {
        result *= num;
        return result;
    }

    private int plus(int result, int num) {
        result += num;
        return result;
    }

    private void checkValidOperator(String op) {
        if (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
            throw new IllegalArgumentException("유효한 연산자가 아닙니다");
        }
    }

    private void checkInputLength(String[] data) {
        if (data.length < 3) {
            throw new IllegalArgumentException("2개 이상의 값을 입력해주세요");
        }
    }

    private void checkNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("input 값이 잘못되었습니다");
        }
    }

}
