package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
