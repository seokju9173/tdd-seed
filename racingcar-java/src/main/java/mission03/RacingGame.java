package mission03;

import mission03.domain.RacingCourse;
import mission03.utils.RacingCarMovementStrategy;
import mission03.utils.RacingCarRandomMovement;
import mission03.view.InputView;
import mission03.view.ResultView;

import java.util.stream.IntStream;

public class RacingGame {

    private static final int ZERO = 0;

    public static void main(String[] args) {
        int carCount;
        int tryCount;

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        carCount = inputView.requestCarCount();
        tryCount = inputView.requestTryCount();

        RacingCourse racingCourse = new RacingCourse(carCount);
        RacingCarMovementStrategy racingCarMovementStrategy = new RacingCarRandomMovement();

        resultView.showRacingResultMessage();
        resultView.showRacingCarsPosition(racingCourse.getCars());

        IntStream.range(ZERO, tryCount)
                .forEach(i -> {
                    System.out.println();
                    racingCourse.moveCars(racingCarMovementStrategy);
                    resultView.showRacingCarsPosition(racingCourse.getCars());
                });
    }
}
