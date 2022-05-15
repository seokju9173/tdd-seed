package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    public void run() {
        Cars cars;

        String names = InputView.getNames();
        cars = new Cars(new MoveStrategyRandom(), names);
        IntStream.range(0, cars.getCarList().size())
                .forEach(i -> cars.getCar(i));
        int round = InputView.getRoundNumber();
        
        IntStream.range(0, round)
                .forEach(i -> {
                    cars.moveCars();
                    ResultView.printGameStatus(cars);
                });

        List<Car> winner = getWinner(cars);
        ResultView.printWinner(winner);
    }

    public List<Car> getWinner(Cars cars) {
        int maxPosition = IntStream.range(0, cars.getCarList().size())
                .map(i -> cars.getCar(i).getPosition())
                .max()
                .getAsInt();
        List<Car> winnerCars = IntStream.range(0, cars.getCarList().size())
                .filter(i -> cars.getCar(i).getPosition() == maxPosition)
                .mapToObj(cars::getCar)
                .collect(Collectors.toList());

        if(winnerCars.size() == 0) {
            throw new IllegalArgumentException("승자가 0명인 오류 발생");
        }
        return winnerCars;
    }

}
