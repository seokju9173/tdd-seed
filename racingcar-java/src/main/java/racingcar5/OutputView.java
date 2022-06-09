package racingcar5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private final static String CAR_NAME_RESULT_DELIMITER = " : ";
    private final static String WINNER_DELIMITER = ", ";
    private final static char POSITION_CHARACTER = '-';

    private static void printCarResult(Car car) {
        StringBuilder stringBuilder = new StringBuilder(car.getName() + CAR_NAME_RESULT_DELIMITER);
        IntStream.range(0, car.getPosition())
                .forEach(i -> stringBuilder.append(POSITION_CHARACTER));
        System.out.println(stringBuilder);
    }

    public static void printCarsResult(Cars cars) {
        IntStream.range(0, cars.getSize())
                .forEach(i -> printCarResult(cars.getCar(i)));
    }

    public static void printAskingRound() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printExecutionResult() {
        System.out.println("실행 결과");
    }

    public static void printWinners(List<Car> winners) {
        String collect = IntStream.range(0, winners.size())
                .mapToObj(i -> winners.get(i).getName())
                .collect(Collectors.joining(WINNER_DELIMITER));
        System.out.println(collect + "가 최종 우승했습니다.");
    }
}
