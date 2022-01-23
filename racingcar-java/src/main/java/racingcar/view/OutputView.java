package racingcar.view;

import racingcar.Car.Car;

import java.util.List;

public class OutputView {
    private static final String PRINT_HOW_MANY_CARS = "자동차 경주에 참여하는 사람의 이름은 무엇인가요?\n" + "여러명 입력이 가능하나 \",\"로 구분됩니다.";
    private static final String PRINT_HOW_MANY_PROGRESS = "시도할 회수는 몇 회 인가요?";
    private static final String PRINT_RESULT = "\n실행 결과";
    private static final String PROGRESS_STRING = "-";
    private static final String PRINT_WINNER = "이(가) 최종 우승했습니다.";

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
            sb.append(car.getCarName()).append(": ");
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

    public static void printWinner(List<Car> winnerCars) {
        StringBuilder sb = new StringBuilder();

        if (winnerCars.size() > 0) {
            sb.append(winnerCars.get(0).getCarName());
        }

        for (int i = 1; i < winnerCars.size(); i++) {
            sb.append(", ").append(winnerCars.get(i).getCarName());
        }

        System.out.println(sb + PRINT_WINNER);
    }
}
