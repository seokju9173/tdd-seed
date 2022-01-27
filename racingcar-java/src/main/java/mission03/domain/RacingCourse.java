package mission03.domain;

import mission03.utils.RacingCarMovement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCourse {

    private final List<RacingCar> cars = new ArrayList<>();
    private final RacingCarMovement racingCarMovement = new RacingCarMovement();

    public List<RacingCar> getCars() {
        return cars;
    }

    public void initRacingCars(int carCount) {
        IntStream.range(0, carCount)
                .forEach(i -> cars.add(new RacingCar()));
    }

    public void moveCars() {
        cars.forEach(car -> {
            if (racingCarMovement.makeRandomMovement()) {
                car.moveCar();
            }
        });
    }
}
