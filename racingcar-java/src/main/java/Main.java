import racingcar.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {
    public static void main(String[] args) {
        OutputView.printHowManyCars();
        String carsNames = InputView.inputCarNames();

        OutputView.printHowManyProgress();
        int progressNumber = InputView.inputProgressTotal();

        new Race(carsNames, progressNumber).racing();
    }
}
