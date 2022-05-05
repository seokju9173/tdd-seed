package step3;

import step3.domain.Cars;
import step3.view.InputView;
import step3.view.OutputView;

public class Racing {

    public void raceStart() {
        OutputView output = new OutputView();
        InputView input = new InputView();

        int count = input.inputRaceData();
        int attempt = input.inputRacingAttempt();

        Cars cars = new Cars(count);

        for (int i = 0; i < attempt; i++) {
            cars.move();
            output.outputMoveCarPosition(cars);
        }
    }
}
