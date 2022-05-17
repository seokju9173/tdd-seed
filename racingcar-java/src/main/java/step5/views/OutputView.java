package step5.views;

import step5.domain.Cars;
import step5.domain.Round;

import static step5.views.InputView.inputCarsName;
import static step5.views.InputView.inputRounds;

public class OutputView {
    private static final String HOW_MAY_CARS_NAME = "자동차의 이름을 작성해 주세요.";
    private static final String HOW_MAY_ROUNDS = "시도할 회수는 몇 회 인가요?";
    private static final String CAR_DISTANCE = "-";

    public static void outputInputCarsName() {
        System.out.println(HOW_MAY_CARS_NAME);
    }

    public static void outputInputRounds(){
        System.out.println(HOW_MAY_ROUNDS);
    }

    public static void outputRounds(Round round){
        round.getRound()
                .forEach((integer, cars) -> {
                    outputDistance(cars);
                    System.out.println();
                });
    }

    private static void outputDistance(Cars cars){
        cars.getCars()
                .forEach(car -> System.out.println(car.getCarName() + " : " + CAR_DISTANCE.repeat(car.getDistance())) );
    }
}
