package racingcar.Car;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final Random random = new Random();
    private static final int MAX_BOUND = 10;
    private static final int MIN_POSITION = 0;

    private List<Car> cars;

    public Cars(String carNames) {
        String[] carNamesSplit = carNames.split(",");
        this.cars = new ArrayList<>();
        for (String carName : carNamesSplit) {
            this.cars.add(new Car(carName.trim()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.drivingCar(random.nextInt(MAX_BOUND));
        }
    }

    public void winner(){
        int winnerPosition = getMaxPosition();
        List<Car> winnerCars = getWinnerCars(winnerPosition);

        OutputView.printWinner(winnerCars);
    }

    private int getMaxPosition() {
        int max = MIN_POSITION;

        for (Car car : cars){
            max = Math.max(car.getPosition(), max);
        }

        return max;
    }

    private List<Car> getWinnerCars(int winnerPosition){
        List<Car> winnerCars = new ArrayList<>();

        for (Car car : cars){
            WinnerCar(winnerCars, car, winnerPosition);
        }

        return winnerCars;
    }

    private void WinnerCar (List<Car> winnerCars, Car car, int winnerPosition){
        if(car.getPosition() == winnerPosition){
            winnerCars.add(car);
        }
    }
}
