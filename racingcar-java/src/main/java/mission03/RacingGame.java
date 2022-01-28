package mission03;

import mission03.domain.RacingCourse;
import mission03.view.InputView;
import mission03.view.ResultView;

public class RacingGame {
    public static void main(String[] args) {

        int carCount;
        int tryCount;

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        carCount = inputView.requestCarCount();
        tryCount = inputView.requestTryCount();

        RacingCourse racingCourse = new RacingCourse(carCount);

        resultView.showRacingResultMessage();
//        resultView.showRacingCarsPosition(tryCount,);
    }
}
