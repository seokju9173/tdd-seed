package step3;

import step3.collections.Car;
import step3.io.Input;
import step3.io.Output;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    public void raceStart(){

        Output output = new Output();
        Input input = new Input();

        output.outputHowManyCar();
        int count = input.inputCarCount();
        output.outputHowManyRacingAttempt();

        List<Car> cars = IntStream.range(0, count)
                .mapToObj(Car::new)
                .collect(Collectors.toList());

        IntStream.range(0, input.inputRacingAttempt())
                .forEach(i -> {
                    System.out.println();
                    cars.forEach(car -> {
                        car.move();
                        car.printDistance();
                    });
                });

    }
}
