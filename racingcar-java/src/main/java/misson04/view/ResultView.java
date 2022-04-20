package misson04.view;

import misson04.domain.RacingCar;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private final static String RESULT_WINNER_POSTFIX = "가 최종 우승했습니다";
    private static final String CAR_POSITION_MARK = "-";

    public void showRacingResultMessage(List<RacingCar> cars) {
        System.out.println(RESULT_MESSAGE);
        showRacingCarsPosition(cars);
    }

    public void showRacingCarsPosition(List<RacingCar> cars) {
        cars.forEach(car -> printCurrentCarsPosition(car.getMovedDistance()));
    }

    public void showRacingWinner(String winners){
        System.out.println(winners + RESULT_WINNER_POSTFIX);
    }

    private void printCurrentCarsPosition(int carDistance) {
        IntStream.range(0, carDistance)
                .forEach(i -> System.out.print(CAR_POSITION_MARK));
        System.out.println();
    }
}
