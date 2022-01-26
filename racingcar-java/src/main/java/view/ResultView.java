package view;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printIntroResult () {
        System.out.println("실행 결과");
    }

    public void printResult(List<Car> cars) {
        for (Car c: cars) {
            System.out.print(c.getName() + " : ");
            printScore(c.getPosition());
        }
        System.out.println("");
    }

    public void printWinners(List<Car> winners) {
        String winnerResult = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winnerResult + "가 최종 우승했습니다.");

    }

    private void printScore(int pos) {
        for (int i = 0; i < pos; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
