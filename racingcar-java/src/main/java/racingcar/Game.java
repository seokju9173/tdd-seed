package racingcar;

import java.util.stream.IntStream;

public class Game {
    public void run() {
        Cars cars;

        int number = InputView.getCarNumber();
        cars = new Cars(new MoveStrategyRandom(), number);
        IntStream.range(0, number).
                forEach(i -> cars.getCar(i));
        int round = InputView.getRoundNumber();
        
        IntStream.range(0, round).
                forEach(i -> {
                    cars.moveCars();
                    ResultView.printGameStatus(cars);
                });
    }

}
