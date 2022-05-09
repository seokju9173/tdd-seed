package racingcar;

public class ResultView {

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
        String[] carsStatus = cars.getCarsStatus();
        for(int i = 0; i < carsStatus.length; i++) {
            System.out.println(carsStatus[i]);
        }
        System.out.println();
    }
}
