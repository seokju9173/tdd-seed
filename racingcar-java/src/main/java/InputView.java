import java.util.Scanner;

public class InputView {

    Scanner sc = new Scanner(System.in);

    int inputNumberCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");

        int numberCar = sc.nextInt();

        checkValidInput(numberCar);
        return numberCar;
    }

    int inputRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        int round = sc.nextInt();

        checkValidInput(round);
        return round;
    }

    private void checkValidInput(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요");
        }
    }

}
