package step3;

import step3.domain.Cars;
import step3.view.Utils;

import java.util.stream.IntStream;

public class Racing {

    private final Utils.OutputView output = new Utils.OutputView();

    public void raceStart() {
        Utils.InputView input = new Utils.InputView();

        int count = input.inputRaceData();
        int attempt = input.inputRacingAttempt();

        Cars cars = new Cars(count);

        cycle(cars, attempt);
    }

    private void cycle(Cars cars, int attempt){
        output.outputMoveCarPosition(cars);
        IntStream.range(0, attempt)
                .forEach( i-> {
                    cars.move();
                    output.outputMoveCarPosition(cars);
                });
    }
}
