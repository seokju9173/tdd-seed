package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private List<Car> cars;

    public Cars(final int count){
        this.cars = IntStream.range(0, count)
                .mapToObj(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move(){
        for(Car car : cars){
            car.move();
        }
    }
}
