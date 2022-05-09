package racingcar;

public class ResultView {

    private static char printCharacter = '-';

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

    public static char getPrintCharacter() {
        return printCharacter;
    }

    public static void setPrintCharacter(char printCharacter) {
        ResultView.printCharacter = printCharacter;
    }
}
