package misson04.view;

import misson04.domain.RacingCar;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String CAR_POSITION_MARK = "-";

    public void showRacingResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void showRacingCarsPosition(List<RacingCar> cars) {
        cars.forEach(car -> printCurrentCarsPosition(car.getMovedDistance()));
    }

    private void printCurrentCarsPosition(int carDistance) {
        IntStream.range(0, carDistance)
                .forEach(i -> System.out.print(CAR_POSITION_MARK));
        System.out.println();
    }
}
