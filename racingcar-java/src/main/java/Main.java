import mission02.Calculator;

public class Main {
    public static void main(String[] args) {
        final String expression = "1 + 2 +";

        Calculator calculator = new Calculator();
        System.out.println(calculator.calculatorValue(expression));
    }
}
