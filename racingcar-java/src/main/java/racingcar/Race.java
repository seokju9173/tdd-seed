package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class Race {
    private int totalCars;
    private int totalProgress;
    private Car[] cars;

    public void racePrepare() {
        Scanner scanner = new Scanner(System.in);

        OutputView.printHowManyCars();
        this.totalCars = InputView.inputCarCount();
        OutputView.printHowManyProgress();
        this.totalProgress = InputView.inputProgressTotal();
        setupCars();
        race();
    }

    public void race() {
        OutputView.printResult();

        for (int i = 0; i < totalProgress; i++) {
            for (int j = 0; j < totalCars; j++) {
                cars[j].drivingCar();
                System.out.println(cars[j].getProgress());
            }
            System.out.println();
        }
    }

    public void setupCars(){
        cars = new Car[totalCars];
        for (int i = 0; i < totalCars; i++) {
            cars[i] = new Car();
        }
    }
}
