package mission03.view;

import mission03.domain.RacingCar;
import mission03.domain.RacingCourse;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final int SPEND_INIT_COUNT = 1;

    public void showRacingResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void showRacingCarsPosition(RacingCourse racingCourse, int tryCount) {
        printCurrentCarsPosition(racingCourse.getCars());
        System.out.println();

        IntStream.range(0, tryCount - SPEND_INIT_COUNT).forEach(i -> {
            racingCourse.moveCars();
            printCurrentCarsPosition(racingCourse.getCars());
            System.out.println("");
        });
    }

    private void printCurrentCarsPosition(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            IntStream.range(0,car.getMovedDistance())
                    .forEach( i -> System.out.print("-"));
            System.out.println();
        }
    }
}
