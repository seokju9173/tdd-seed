package step3;

import step3.collections.Car;
import step3.collections.Round;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    public void raceStart() {

        OutputView output = new OutputView();
        InputView input = new InputView();

        output.outputHowManyCar();
        int count = input.inputRaceData();
        output.outputHowManyRacingAttempt();

        Round round = new Round(0, IntStream.range(0, count)
                .mapToObj(Car::new)
                .collect(Collectors.toList()));

        IntStream.range(0, input.inputRaceData())
                .forEach(i -> round.carMove());
    }
}
