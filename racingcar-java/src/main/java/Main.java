import racingcar.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {
    public static void main(String[] args) {
        OutputView.printHowManyCars();
        int carsNumber = InputView.inputCarCount();

        OutputView.printHowManyProgress();
        int progressNumber = InputView.inputProgressTotal();

        new Race(carsNumber, progressNumber).racing();
    }
}
