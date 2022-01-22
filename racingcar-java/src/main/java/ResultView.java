import java.util.List;

public class ResultView {

    void printIntroResult () {
        System.out.println("실행 결과");
    }

    void printResult(List<Car> cars) {
        for (Car c: cars) {
            printScore(c.getPosition());
        }
        System.out.println("");
    }

    private void printScore(int pos) {
        for (int i = 0; i < pos; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
