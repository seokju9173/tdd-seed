package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String printCharacter = "-";
    private static final String winnerDelimiter = ", ";
    private static final String nameAndPrintDelimiter = " : ";
    private static final String endMessage = "가 최종 우승했습니다.";

    public static void roundMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static List<String> getCarsStatus(List<Car> cars) {
        List<String> strings = new ArrayList<>();
        IntStream.range(0, cars.size())
                .mapToObj(i -> cars.get(i).getName() + nameAndPrintDelimiter + positionString(cars.get(i).getPosition()))
                .forEach(strings::add);
        return strings;
    }

    public static void printGameStatus(Cars cars) {
        List<String> carsStatus = getCarsStatus(cars.getCarList());
        IntStream.range(0, carsStatus.size())
                .mapToObj(i -> carsStatus.get(i))
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(List<Car> winner) {
        IntStream.range(0, winner.size() - 1).
                mapToObj(i -> winner.get(i).getName() + winnerDelimiter)
                .forEach(System.out::print);
        System.out.println(
                winner.get(winner.size() - 1).getName() + endMessage);
    }

    public static String positionString(int distance) {
        String character = printCharacter;
        return IntStream.rangeClosed(1, distance).
                filter(i -> i == distance).
                mapToObj(i -> character.repeat(i)).
                collect(Collectors.joining());
    }
}
