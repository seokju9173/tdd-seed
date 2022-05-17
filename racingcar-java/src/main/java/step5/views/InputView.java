package step5.views;

import java.util.Scanner;

import static step5.views.OutputView.outputInputCarsName;
import static step5.views.OutputView.outputInputRounds;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static String inputCarsName() {
        outputInputCarsName();
        return input.next();
    }

    public static int inputRounds() {
        outputInputRounds();
        return input.nextInt();
    }
}
