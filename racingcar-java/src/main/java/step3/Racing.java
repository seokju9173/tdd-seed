package step3;

import step3.view.InputView;
import step3.view.OutputView;

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
