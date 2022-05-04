package step3;

import step3.collections.Cars;
import step3.io.Input;
import step3.io.Output;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Racing {

    private static String[] cars;
    private int car, trial;

    public void raceStart(){

    }

    public List<Cars> createCars(int carsCount){
        return IntStream.range(0, carsCount)
                .mapToObj(i -> new Cars(i , "-"))
                .collect(Collectors.toList());
    }

    public void racingCar() {

        initializeCar();
        Arrays.fill(cars, "-");

        for (int j = 0; j < car; j++) {
            System.out.println(cars[j]);
        }

        for (int i = 0; i < trial; i++) {
            System.out.println();
            printCarPosition(cars);
        }
    }

    private void initializeCar() {
        Input input = new Input();
        Output output = new Output();
        output.outputHowManyCar();
        car = input.inputCar();
        output.outputHowManyRacingAttempt();
        trial = input.inputRacingTrial();
        cars = new String[car];
    }

    private String stopAndGo() {
        Random random = new Random();
        int stopAndGo = random.nextInt(10);
        if (stopAndGo >= 4) {
            return "-";
        }
        return "";
    }

    private String[] printCarPosition(String[] cars) {
        for (int j = 0; j < cars.length; j++) {
            cars[j] += stopAndGo();
            System.out.println(cars[j]);
        }
        return cars;
    }
}
