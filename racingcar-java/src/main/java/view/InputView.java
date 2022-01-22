package view;

import java.util.Scanner;

public class InputView {

    private static final int MIN_ROUND_INPUT = 0;

    private Scanner sc = new Scanner(System.in);

    public int inputNumberCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return sc.nextInt();
    }

    public int inputRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        int round = sc.nextInt();

        checkValidRoundInput(round);

        return sc.nextInt();
    }

    private void checkValidRoundInput(int round) {
        if (round <= MIN_ROUND_INPUT) {
            throw new IllegalArgumentException("회수는 1회 이상이어야 합니다");
        }
    }

}
