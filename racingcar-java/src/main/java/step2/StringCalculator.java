package step2;

import java.util.Scanner;

public class StringCalculator {
    public String[] stringBlankSplit(String inputString) {
        return inputString.split(" ");
    }

    public int addition(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int subtraction(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public int multiplication(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public int division(int firstNumber, int secondNumber) {
        try {
            return firstNumber / secondNumber;
        }
        catch (Exception e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
        return 0;
    }

    public int calculate(int firstNumber, char operator, int secondNumber) {
        if (operator == '+') {
            return addition(firstNumber, secondNumber);
        }
        if (operator == '-') {
            return subtraction(firstNumber, secondNumber);
        }
        if (operator == '*') {
            return multiplication(firstNumber, secondNumber);
        }
        if (operator == '/') {
            return division(firstNumber, secondNumber);
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }
}
