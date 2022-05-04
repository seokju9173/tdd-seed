package step3.io;

import java.util.Scanner;

public class Input {
    Scanner input = new Scanner(System.in);

    public int inputCarCount() {
        return input.nextInt();
    }

    public int inputRacingAttempt() {
        return input.nextInt();
    }
}
