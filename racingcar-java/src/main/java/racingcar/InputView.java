package racingcar;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static int getCarNumber() {
        ResultView.carMessage();
        return sc.nextInt();
    }


    public static int getRoundNumber() {
        ResultView.roundMessage();
        return sc.nextInt();
    }
}
