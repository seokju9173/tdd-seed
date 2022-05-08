package racingcar;

public class Game {
    public void gameLogic() {
        Cars cars;
        Users users;

        InputView inputView = new InputView();
        ResultView.carMessage();
        int number = inputView.getNumber();
        cars = new Cars(number);
        users = new Users(number);
        for(int i = 0; i < number; i++) {
            users.
                    getUser(i).
                    setCar(
                            cars.getCar(i)
                    );
        }
        ResultView.roundMessage();
        int round = inputView.getNumber();

        for(int i = 0; i < round; i++) {
            users.usersGo();
            ResultView.printGameStatus(cars);
        }
    }

}
