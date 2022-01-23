package view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private static final int MIN_ROUND_INPUT = 0;

    private Scanner sc = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표를(,) 기준으로 구분)");
        return sc.next();
    }

    public int inputRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        int round = sc.nextInt();

        checkValidRoundInput(round);

        return round;
    }

    private void checkValidRoundInput(int round) {
        if (round <= MIN_ROUND_INPUT) {
            throw new IllegalArgumentException("회수는 1회 이상이어야 합니다");
        }
    }
}
