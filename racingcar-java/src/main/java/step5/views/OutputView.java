package step5.views;

import step5.domain.Cars;
import step5.domain.Round;

import static step5.views.InputView.inputCarsName;
import static step5.views.InputView.inputRounds;

public class OutputView {
    private static final String HOW_MAY_CARS_NAME = "자동차의 이름을 작성해 주세요.";
    private static final String HOW_MAY_ROUNDS = "시도할 회수는 몇 회 인가요?";
    private static final String CAR_DISTANCE = "-";
    private static final String CAR_BREAK_POINT = ",";
    private static final String CAR_WINNER_FORWARD_COMMENT = "우승자는 ";
    private static final String CAR_WINNER_BACKWARD_COMMENT = " 입니다";

    public static void outputInputCarsName() {
        System.out.println(HOW_MAY_CARS_NAME);
    }

    public static void outputInputRounds() {
        System.out.println(HOW_MAY_ROUNDS);
    }

    public static void outputRounds(final Round round) {
        round.getRound()
                .forEach((integer, cars) -> {
                    outputDistance(cars);
                    System.out.println();
                });
        outputWinner(round);
    }

    private static void outputDistance(final Cars cars) {
        cars.getCars()
                .forEach(car -> System.out.println(car.getCarName() + " : " + CAR_DISTANCE.repeat(car.getDistance())));
    }

    private static void outputWinner(final Round round) {
        System.out.println(CAR_WINNER_FORWARD_COMMENT + String.join(CAR_BREAK_POINT, round.findWinners()) + CAR_WINNER_BACKWARD_COMMENT);
    }
}
