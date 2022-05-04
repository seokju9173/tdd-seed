package step3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Racing {

    private static String[] cars;
    private int car, trial;

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
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차의 대수는 몇 대 인가요?");
        car = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        trial = sc.nextInt();
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

    private String[] printCarPosition(String[] cars){
        for (int j = 0; j < cars.length; j++) {
            cars[j] += stopAndGo();
            System.out.println(cars[j]);
        }
        return cars;
    }
}
