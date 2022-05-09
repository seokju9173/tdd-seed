package racingcar;

public class Game {
    public void run() {
        Cars cars;
        Users users;

        int number = InputView.getCarNumber();
        cars = new Cars(number);
        users = new Users(number);
        for(int i = 0; i < number; i++) {
            users.getUser(i).
            setCar(cars.getCar(i));
        }
        int round = InputView.getRoundNumber();

        for(int i = 0; i < round; i++) {
            users.usersGo();
            ResultView.printGameStatus(cars);
        }
    }

}
