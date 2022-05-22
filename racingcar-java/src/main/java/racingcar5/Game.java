package racingcar5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    public static void run() {
        Cars cars = new Cars(new RandomMoveStrategy(), InputView.inputNames());
        OutputView.printAskingRound();
        int round = InputView.inputRound();
        System.out.println();

        OutputView.printExecutionResult();
        IntStream.range(0, round)
                .forEach(i -> {
                    cars.moveCars();
                    OutputView.printCarsResult(cars);
                    System.out.println();
                });
        List<Car> winners = findWinner(cars);
        OutputView.printWinners(winners);
    }

    public static List<Car> findWinner(Cars cars) {
        int maxPosition = IntStream.range(0, cars.getSize())
                .map(i -> cars.getCar(i).getPosition())
                .max()
                .getAsInt();
        List<Car> winners = IntStream.range(0, cars.getSize())
                .filter(i -> cars.getCar(i).getPosition() == maxPosition)
                .mapToObj(cars::getCar)
                .collect(Collectors.toList());
        if(winners.size() <= 0) {
            throw new IllegalArgumentException("승자가 없음");
        }
        return winners;
    }
}
