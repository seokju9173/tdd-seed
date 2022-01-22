package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private int carsTotal;
    private int progressTotal;
    private Car[] cars;

    public void racePrepare() {
        OutputView.printHowManyCars();
        this.carsTotal = InputView.inputCarCount();

        OutputView.printHowManyProgress();
        this.progressTotal = InputView.inputProgressTotal();

        setupCars();

        raceResult();
    }

    private void setupCars() {
        cars = new Car[carsTotal];
        for (int i = 0; i < carsTotal; i++) {
            cars[i] = new Car();
        }
    }

    private void raceResult() {
        OutputView.printResult();

        for (int i = 0; i < progressTotal; i++) {
            raceOneCycle();
        }
    }

    private void raceOneCycle() {
        moveCars(cars);
        OutputView.printCurrentCarsPosition(cars);
    }

    //한 사이클에 모든 차들 전진 혹은 정차
    private void moveCars(Car[] cars) {
        for (int j = 0; j < carsTotal; j++) {
            cars[j].drivingCar();
        }
    }
}
