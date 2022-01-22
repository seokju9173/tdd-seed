package racingcar;

import racingcar.Car.Cars;
import racingcar.view.OutputView;

public class Race {
    private final int progressTotal;
    private Cars cars;

    public Race(int carsTotal, int progressTotal) {
        cars = new Cars(carsTotal);
        this.progressTotal = progressTotal;
    }

    public void racing() {
        OutputView.printResult();

        for (int i = 0; i < progressTotal; i++) {
            raceOneCycle();
        }
    }

    private void raceOneCycle() {
        cars.move();
        OutputView.printCurrentCarsPosition(cars.getCars());
    }
}
