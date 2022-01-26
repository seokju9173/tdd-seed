import domain.RacingCar;
import view.InputView;
import view.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        InputView iv = new InputView();
        String nameCars = iv.inputCarNames();
        int round = iv.inputRound();

        RacingCar rc = new RacingCar(nameCars);

        ResultView rv = new ResultView();
        rv.printIntroResult();

        for (int i = 0; i < round; i++){
            rc.playOneRound();
            rv.printResult(rc.getCars());
        }

        rv.printWinners(rc.getWinners());
    }
}
