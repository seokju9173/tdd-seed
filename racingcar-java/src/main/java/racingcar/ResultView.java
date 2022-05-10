package racingcar;

import java.util.List;

public class ResultView {

    private static final char printCharacter = '-';

    public static void carMessage() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void roundMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static void printMessage() {
        System.out.println("실행 결과");
    }

    public static void printGameStatus(Cars cars) {
        List<String> carsStatus = cars.getCarsStatus();
        for(int i = 0; i < carsStatus.size(); i++) {
            System.out.println(carsStatus.get(i));
        }
        System.out.println();
    }

    public static char getPrintCharacter() {
        return printCharacter;
    }
    
}
