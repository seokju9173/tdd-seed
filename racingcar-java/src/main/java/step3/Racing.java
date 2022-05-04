package step3;

import step3.collections.Car;
import step3.io.Input;
import step3.io.Output;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    public void raceStart() {

        Output output = new Output();
        Input input = new Input();

        //차 몇대?
        output.outputHowManyCar();
        List<Car> cars = IntStream.range(0, input.inputCarCount())
                .mapToObj(i -> new Car(i, "-"))
                .collect(Collectors.toList());

        //몇라운드?
        output.outputHowManyRacingAttempt();
        IntStream.range(0, input.inputRacingAttempt())
                .forEach(i -> {
                    cars.stream().forEach(car -> {
                        car.setDistance(goAndStop());
                        car.printDistance();
                    });
                    System.out.println();
                });

    }

    private String goAndStop() {
        Random point = new Random();
        if (point.nextInt(10) >= 4) {
            return "-";
        }
        return "";
    }
}
