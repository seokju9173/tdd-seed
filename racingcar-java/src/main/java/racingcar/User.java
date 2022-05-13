package racingcar;

import java.util.Random;

public class User {

    private Car car;
    private Random random;

    public User() {
        random = new Random();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int random() {
        return random.nextInt(10);
    }

    public void go() {
        int number = random();
        if(number >= 4) {
            car.move();
        }
    }

}
