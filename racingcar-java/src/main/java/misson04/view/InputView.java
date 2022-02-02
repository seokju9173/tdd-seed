package misson04.view;

import misson04.exception.FormatException;

import java.util.Scanner;

public class InputView {

    private static final String REQUEST_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String REQUEST_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public int requestCarCount() {
        System.out.println(REQUEST_CAR_MESSAGE);
        return stringToNumber(scanner.next());
    }

    public int requestTryCount() {
        System.out.println(REQUEST_COUNT_MESSAGE);
        return stringToNumber(scanner.next());
    }

    private int stringToNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new FormatException();
        }
    }
}
