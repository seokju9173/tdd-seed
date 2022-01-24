package racingcar.Car;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private static final Random random = new Random();
    private static final int MAX_BOUND = 10;
    private static final int MIN_POSITION = 0;

    private final List<Car> cars;

    public Cars(String carNames) {
        String[] carNamesSplit = carNames.split(",");
        this.cars = Arrays.stream(carNamesSplit)
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.drivingCar(random.nextInt(MAX_BOUND));
        }
    }

    public void winner() {
        int winnerPosition = getMaxPosition();
        List<Car> winnerCars = getWinnerCars(winnerPosition);

        OutputView.printWinner(winnerCars);
    }

    private int getMaxPosition() {
        int max = MIN_POSITION;

        for (Car car : cars) {
            max = Math.max(car.getPosition(), max);
        }

        return max;
    }

    public List<Car> getWinnerCars(int winnerPosition) {
        List<Car> winnerCars = new ArrayList<>();

        for (Car car : cars) {
            winnerCar(winnerCars, car, winnerPosition);
        }

        return winnerCars;
    }

    private void winnerCar(List<Car> winnerCars, Car car, int winnerPosition) {
        if (car.getPosition() == winnerPosition) {
            winnerCars.add(car);
        }
    }
}
