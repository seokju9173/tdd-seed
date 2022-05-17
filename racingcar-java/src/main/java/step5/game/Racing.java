package step5.game;

import step5.domain.Cars;
import step5.domain.Round;

import java.util.stream.IntStream;

import static step5.views.InputView.inputCarsName;
import static step5.views.InputView.inputRounds;
import static step5.views.OutputView.outputRounds;

public class Racing {
    public void start(){
        Cars cars = new Cars(inputCarsName());
        int attempt = inputRounds();

        cycle(cars, attempt);
    }

    private void cycle(final Cars _cars, final int attempt) {
        Cars cars = _cars;
        Round round = new Round(0, cars);
        int bound = attempt;
        for (int roundNum = 1; roundNum <= bound; roundNum++) {
            cars = cars.move();
            round.add(roundNum, cars.move());
        }

        outputRounds(round);
    }
}
