package mission03.view;

import mission03.domain.RacingCar;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String CAR_POSITION_MARK = "-";

    public void showRacingResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

//    public void showRacingCarsPosition(int tryCount, Map<RacingCar, List<Integer>> map){
//        IntStream.range(0, tryCount)
//                .forEach();
//    }

    private void printCurrentCarsPosition(List<RacingCar> cars) {
        cars.forEach(car -> {
            IntStream.range(0, car.getMovedDistance())
                    .forEach(i -> System.out.print(CAR_POSITION_MARK));
            System.out.println();
        });
    }
}
