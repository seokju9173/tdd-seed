package step3.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner input = new Scanner(System.in);

    public static String inputCarNames() {
        OutputView.outputHowManyCar();
        return input.next();
    }

    public static int inputRacingAttempt() {
        OutputView.outputHowManyRacingAttempt();
        return input.nextInt();
    }
}
