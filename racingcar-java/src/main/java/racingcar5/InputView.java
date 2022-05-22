package racingcar5;

import java.util.Scanner;

public class InputView {

    private final static Scanner sc = new Scanner(System.in);

    public static String inputNames() {
        return sc.next();
    }

    public static int inputRound() {
        return sc.nextInt();
    }
}
