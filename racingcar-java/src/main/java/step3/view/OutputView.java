package step3.view;

import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.Round;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class OutputView {

    private static final String OUTPUT_HOW_MANY_CAR = "자동차의 이름은 무엇 인가요?";
    private static final String OUTPUT_HOW_MANY_RACING_ATTEMPT = "시도할 회수는 몇 회 인가요?";
    private static final String OUTPUT_MOVE_CAR_POSITION = "-";
    private static final String OUTPUT_JOINING_TEXT = ", ";
    private static final String OUTPUT_WINNER_TEXT = "가 최종 우승했습니다.";

    public static void outputHowManyCar() {
        System.out.println(OUTPUT_HOW_MANY_CAR);
    }

    public static void outputHowManyRacingAttempt() {
        System.out.println(OUTPUT_HOW_MANY_RACING_ATTEMPT);
    }

    public static void outputRound(Round round) {
        round.getRound().forEach((integer, cars) -> {
            outputCarsDistance(cars);
            System.out.println();
        });
        outputWinner(round);
    }

    private static void outputCarsDistance(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.print(car.getCarName() + " : ");
            System.out.println(OUTPUT_MOVE_CAR_POSITION.repeat(car.getDistance()));
        });
    }

    private static void outputWinner(Round round) {
        System.out.println(String.join(OUTPUT_JOINING_TEXT, round.getWinners()) + OUTPUT_WINNER_TEXT);
    }
}
