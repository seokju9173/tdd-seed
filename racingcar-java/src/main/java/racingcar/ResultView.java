package racingcar;

import java.util.List;

public class ResultView {

    public static void carMessage() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void roundMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static void printMessage() {
        System.out.println("실행 결과");
    }

    public static void printGameStatus(Cars cars) {
        cars.printCarsStatus();
        System.out.println();
    }
}
