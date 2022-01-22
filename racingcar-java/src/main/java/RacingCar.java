import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    List<Car> cars;

    public RacingCar(int numberCars) {
        this.cars = setCars(numberCars);
    }

    List<Car> setCars(int numberCar) {
        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < numberCar; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    List<Car> getCars() {
        return cars;
    }

    int getRandom() {
        return new Random().nextInt(10);
    }

    void playOneRound(List<Car> cars) {
        for (Car c: cars) {
            c.move(getRandom());
        }
    }


}
