package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount() {
        return scanner.nextInt();
    }

    public static int inputProgressTotal() {
        return scanner.nextInt();
    }
}
