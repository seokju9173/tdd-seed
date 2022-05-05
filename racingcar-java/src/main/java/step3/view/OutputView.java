package step3.view;

import step3.domain.Car;
import step3.domain.Cars;


public class OutputView {

    private static final String OUTPUT_HOW_MANY_CAR = "자동차의 대수는 몇 대 인가요?";
    private static final String OUTPUT_HOW_MANY_RACING_ATTEMPT = "시도할 회수는 몇 회 인가요?";
    private static final String OUTPUT_MOVE_CAR_POSITION = "-";

    public void outputHowManyCar() {
        System.out.println(OUTPUT_HOW_MANY_CAR);
    }

    public void outputHowManyRacingAttempt() {
        System.out.println(OUTPUT_HOW_MANY_RACING_ATTEMPT);
    }

    public void outputMoveCarPosition(final Cars cars){
        for(Car car : cars.getCars()){
            System.out.println(OUTPUT_MOVE_CAR_POSITION.repeat(car.getDistance()));
        }
    }

}
