package step3.view;

import java.util.Scanner;

public class InputView {
    OutputView outputView = new OutputView();

    Scanner input = new Scanner(System.in);

    public int inputRaceData() {
        outputView.outputHowManyCar();
        return input.nextInt();
    }

    public int inputRacingAttempt() {
        outputView.outputHowManyRacingAttempt();
        return input.nextInt();
    }

}
