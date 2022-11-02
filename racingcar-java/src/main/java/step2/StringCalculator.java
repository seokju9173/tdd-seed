package step2;

import java.util.Scanner;

public class StringCalculator {
    public String[] stringBlankSplit(String inputString) {
        return inputString.split(" ");
    }

    public int stringToInt(String string) {
        return Integer.parseInt(string);
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
        return firstNumber / secondNumber;
    }
}
