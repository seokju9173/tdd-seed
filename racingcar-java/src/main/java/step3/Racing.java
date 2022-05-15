package step3;

import step3.domain.Cars;
import step3.domain.Round;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    public void raceStart() {
        String carNames = InputView.inputCarNames();
        int attempt = InputView.inputRacingAttempt();

        Cars cars = new Cars(carNames);
        Round round = new Round(0, cars);

        cycle(cars, attempt, round);
    }

    private void cycle(final Cars _cars, final int attempt, final Round round) {
        Cars cars = _cars;
        for (int i = 1; i <= attempt; i++) {
            cars = cars.move();
            round.add(i, cars);
        }

        OutputView.outputRound(round);
    }
}
