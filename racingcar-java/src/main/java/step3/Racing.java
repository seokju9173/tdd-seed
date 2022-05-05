package step3;

import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.Round;
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


        int bound = input.inputRaceData();

    }
}
