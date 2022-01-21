package racingcar;

import java.util.Scanner;

public class Race {
    private int totalCars;
    private int totalDriving;

    public Race() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        this.totalCars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.totalDriving = scanner.nextInt();
    }

    public void racing() {
        Car[] cars = new Car[totalCars];
        for (int i = 0; i < totalCars; i++) {
            cars[i] = new Car();
        }

        System.out.println("실행 결과");

        for (int i = 0; i < totalDriving; i++) {
            for (int j = 0; j < totalCars; j++) {
                cars[j].drivingCar();
                System.out.println(cars[j].getProgress());
            }
            System.out.println();
        }
    }
}
