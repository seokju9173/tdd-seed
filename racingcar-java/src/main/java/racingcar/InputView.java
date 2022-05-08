package racingcar;

import java.util.Scanner;

public class InputView {

    private Scanner sc;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public int getNumber() {
        return sc.nextInt();
    }

}
