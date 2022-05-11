package racingcar;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String printCharacter = "-";

    public static void carMessage() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void roundMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static void printGameStatus(Cars cars) {
        List<String> carsStatus = cars.getCarsStatus();
        IntStream.range(0, carsStatus.size()).
                mapToObj(i -> carsStatus.get(i)).
                forEach(System.out::println);
        System.out.println();
    }

    public static String getPrintCharacter() {
        return printCharacter;
    }

}
