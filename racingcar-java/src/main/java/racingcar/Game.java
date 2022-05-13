package racingcar;

import java.util.stream.IntStream;

public class Game {
    public void run() {
        Cars cars;
        Users users;

        int number = InputView.getCarNumber();
        cars = new Cars(number);
        users = new Users(number);
        IntStream.range(0, number).
                forEach(i -> users.getUser(i).setCar(cars.getCar(i)));
        int round = InputView.getRoundNumber();
        
        IntStream.range(0, round).
                forEach(i -> {
                    users.usersGo();
                    ResultView.printGameStatus(cars);
                });
    }

}
