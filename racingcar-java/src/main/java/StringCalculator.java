import java.util.ArrayList;

public class StringCalculator {

    private final String[] OPERATORS = {"+", "-", "*", "/"};

    ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<String> operators = new ArrayList<>();
    int result;

    int calculate(String string) {
        numbers.clear();
        operators.clear();

        listInit(string);
        result = numbers.get(0);

        for(int i=0 ; i<operators.size() ; i++)
            if(operators.get(i).equals("+"))
                operAdd(numbers.get(i+1));
            else if(operators.get(i).equals("-"))
                operSub(numbers.get(i+1));
            else if(operators.get(i).equals("*"))
                operMul(numbers.get(i+1));
            else if(operators.get(i).equals("/"))
                operDiv(numbers.get(i+1));

        return result;
    }

    void listInit(String string) {
        if(string == null)
            throw new IllegalArgumentException("null 값이 입력됨");

        String[] strings = string.split(" ");
        for(int i=0 ; i<strings.length ; i++)
            if(isNumber(strings[i]))
                numbers.add(Integer.parseInt(strings[i]));
            else if(isOperator(strings[i]))
                operators.add(strings[i]);
            else
                throw new IllegalArgumentException("숫자 및 사칙연산 기호 아님");

        if(numbers.size() != operators.size() + 1)
            throw new IllegalArgumentException("연산자와 피연산자의 수가 맞지 않음");
        if(operators.size() == 0)
            throw new IllegalArgumentException("연산자가 없음(공백문자열)");
    }

    // string이 숫자로만 이루어져 있는지 판별
    boolean isNumber(String string) {
        for(int i=0 ; i<string.length() ; i++)
            if(!Character.isDigit(string.charAt(i)))
                return false;
        return true;
    }

    // 문자열이 연산자인지 확인
    boolean isOperator(String op) {
        for(String s : OPERATORS)
            if(op.equals(s))
                return true;
        return false;
    }

    void operAdd(int number) {
        result += number;
    }

    void operSub(int number) {
        result -= number;
    }

    void operMul(int number) {
        result *= number;
    }

    void operDiv(int number) {
        if(number == 0)
            throw new ArithmeticException("Divizion By Zero");
        result /= number;
    }

}
