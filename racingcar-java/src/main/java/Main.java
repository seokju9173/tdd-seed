import mission02.Calculator;

public class Main {
    public static void main(String[] args) {
        final String expression = "1 * 5";
        Calculator calculator = new Calculator(expression);

        System.out.println(calculator.getCalculatorValue());
    }
}
