package racingcar;

public class Game {
    public void gameLogic() {
        Cars cars;
        Users users;

        ResultView.carMessage();
        int number = InputView.getNumber();
        cars = new Cars(number);
        users = new Users(number);
        for(int i = 0; i < number; i++) {
            users.getUser(i).
            setCar(cars.getCar(i));
        }
        ResultView.roundMessage();
        int round = InputView.getNumber();

        for(int i = 0; i < round; i++) {
            users.usersGo();
            ResultView.printGameStatus(cars);
        }
    }

}
