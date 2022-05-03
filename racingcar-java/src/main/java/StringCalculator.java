import java.util.ArrayList;

public class StringCalculator {

    private final static ArrayList<String> OPERATORS = new ArrayList<>();
    private final static int OPERATORSIZE = 4;

    StringCalculator() {
        if(OPERATORS.size()<OPERATORSIZE) {
            OPERATORS.add("+");
            OPERATORS.add("-");
            OPERATORS.add("*");
            OPERATORS.add("/");
        }
    }

    public int calculate(String string) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();

        listInit(string, numbers, operators);
        int result = numbers.get(0);

        for(int i=0; i < operators.size(); i++) {
            String operator = operators.get(i);

            if (operator.equals("+")) {
                result = operAdd(result, numbers.get(i + 1));
            }
            if (operator.equals("-")) {
                result = operSub(result, numbers.get(i + 1));
            }
            if (operator.equals("*")) {
                result = operMul(result, numbers.get(i + 1));
            }
            if (operator.equals("/")) {
                result = operDiv(result, numbers.get(i + 1));
            }
        }

        return result;
    }

    private void listInit(String string, ArrayList<Integer> numbers, ArrayList<String> operators) {
        if(string == null) {
            throw new IllegalArgumentException("null 값이 입력됨");
        }

        String[] strings = string.split(" ");
        for(int i=0; i < strings.length; i++)
            if(isNumber(strings[i])) {
                numbers.add(Integer.parseInt(strings[i]));
            } else if(isOperator(strings[i])) {
                operators.add(strings[i]);
            } else {
                throw new IllegalArgumentException("숫자 및 사칙연산 기호 아님");
            }

        if(numbers.size() != operators.size() + 1) {
            throw new IllegalArgumentException("연산자와 피연산자의 수가 맞지 않음");
        }
        if(operators.size() == 0) {
            throw new IllegalArgumentException("연산자가 없음(공백문자열)");
        }
        if(numbers.size() == 0) {
            throw new IllegalArgumentException("피연산자가 없음");
        }
        if(numbers == null || operators == null) {
            throw new IllegalArgumentException("널 값이 들어옴");
        }
    }

    // string이 숫자로만 이루어져 있는지 판별
    private boolean isNumber(String string) {
        for(int i=0; i < string.length(); i++)
            if(!Character.isDigit(string.charAt(i)))
                return false;
        return true;
    }

    // 문자열이 연산자인지 확인
    private boolean isOperator(String op) {
        return OPERATORS.contains(op);
    }

    private int operAdd(int first, int second) {
        return first + second;
    }

    private int operSub(int first, int second) {
        return first - second;
    }

    private int operDiv(int first, int second) {
        if(second == 0) {
            throw new ArithmeticException("Divizion By Zero");
        }
        if(second < 0) {
            throw new ArithmeticException("음수로 나눔");
        }
        return first / second;
    }

    private int operMul(int first, int second) {
        return first * second;
    }

}
