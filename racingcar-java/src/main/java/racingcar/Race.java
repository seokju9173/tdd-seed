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
        race();
    }

    public void race() {
        OutputView.printResult();

        //아래 for문을 추가적으로 매소드를 분리 시킬수 있을 것 같음
        for (int i = 0; i < progressTotal; i++) {
            // 아래 구문을 OutputView로 이동해야함
            for (int j = 0; j < carsTotal; j++) {
                cars[j].drivingCar();
                System.out.println(cars[j].getProgress());
            }
            System.out.println();
        }
    }

    public void setupCars(){
        cars = new Car[carsTotal];
        for (int i = 0; i < carsTotal; i++) {
            cars[i] = new Car();
        }
    }
}
