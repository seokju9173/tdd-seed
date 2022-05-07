package step3;

import step3.domain.Cars;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.stream.IntStream;

public class Racing {

    public void raceStart() {
        String carNames = InputView.inputCarNames();
        int attempt = InputView.inputRacingAttempt();

        Cars cars = new Cars(carNames);

        cycle(cars, attempt);
    }

    private void cycle(Cars cars, int attempt) {
        OutputView.outputMoveCarPosition(cars);
        IntStream.range(0, attempt)
                .forEach(i -> {
                    cars.move();
                    OutputView.outputMoveCarPosition(cars);
                });
    }
}
