package step3;

import step3.domain.Cars;

import java.util.stream.IntStream;

import static step3.view.Utils.OutputView;
import static step3.view.Utils.InputView;

public class Racing {

    public void raceStart() {

        String carNames = InputView.inputCarNames();
        int attempt = InputView.inputRacingAttempt();

        Cars cars = new Cars(carNames);

        cycle(cars, attempt);
    }

    private void cycle(Cars cars, int attempt){
        OutputView.outputMoveCarPosition(cars);
        IntStream.range(0, attempt)
                .forEach( i-> {
                    cars.move();
                    OutputView.outputMoveCarPosition(cars);
                });
    }
}
