package mission03;

import mission03.domain.RacingCourse;
import mission03.view.InputView;
import mission03.view.ResultView;

public class RacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.announceRacingEvent();

        RacingCourse racingCourse = new RacingCourse();
        racingCourse.initRacingCars(inputView.getCarCount());

        resultView.showRacingResultMessage();
        resultView.showRacingCarsPosition(racingCourse,inputView.getTryCount());
    }
}
