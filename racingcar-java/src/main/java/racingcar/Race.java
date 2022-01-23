package racingcar;

import racingcar.Car.Cars;
import racingcar.view.OutputView;

public class Race {
    private final int progressTotal;
    private Cars cars;

    public Race(String carNames, int progressTotal) {
        cars = new Cars(carNames);
        this.progressTotal = progressTotal;
    }

    public void racing() {
        OutputView.printResult();

        for (int i = 0; i < progressTotal; i++) {
            raceOneCycle();
        }

        cars.winner();
    }

    private void raceOneCycle() {
        cars.move();
        OutputView.printCurrentCarsPosition(cars.getCars());
    }
}
