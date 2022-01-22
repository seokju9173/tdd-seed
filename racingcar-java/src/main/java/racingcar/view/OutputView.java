package racingcar.view;

import racingcar.Car.Car;

import java.util.List;

public class OutputView {
    private static final String PRINT_HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String PRINT_HOW_MANY_PROGRESS = "시도할 회수는 몇 회 인가요?";
    private static final String PRINT_RESULT = "\n실행 결과";
    private static final String PROGRESS_STRING = "-";

    public static void printHowManyCars() {
        System.out.println(PRINT_HOW_MANY_CARS);
    }

    public static void printHowManyProgress() {
        System.out.println(PRINT_HOW_MANY_PROGRESS);
    }

    public static void printResult() {
        System.out.println(PRINT_RESULT);
    }

    public static void printCurrentCarsPosition(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            printCurrentCarPosition(sb, car);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void printCurrentCarPosition(StringBuilder sb, Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(PROGRESS_STRING);
        }
    }
}
