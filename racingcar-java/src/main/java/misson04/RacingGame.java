package misson04;

import misson04.domain.RacingCourse;
import misson04.domain.RacingInfo;
import misson04.utils.RacingCarMovementStrategy;
import misson04.utils.RacingCarRandomMovement;
import misson04.view.InputView;
import misson04.view.ResultView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {

    private static final int ZERO = 0;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingCarMovementStrategy racingCarMovementStrategy = new RacingCarRandomMovement();

        List<String> names = inputView.requestInputNames();
        int tryCount = inputView.requestTryCount();

        RacingCourse racingCourse = new RacingCourse(names.size(), names);
        resultView.showRacingResultMessage(racingCourse.getCars());

        IntStream.range(ZERO, tryCount)
                .forEach(i -> {
                    System.out.println();
                    racingCourse.moveCars(racingCarMovementStrategy);
                    resultView.showRacingCarsPosition(racingCourse.getCars());
                });

        RacingInfo racingInfo = new RacingInfo(racingCourse);
        resultView.showRacingWinner(racingInfo.getRacingWinner());
    }
}


