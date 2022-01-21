import java.util.Random;

public class RacingCar {

    Random random = new Random();
    ResultView rv = new ResultView();

    void racingMain() {
        InputView iv = new InputView();

        int numberCar = iv.inputNumberCar();
        int round = iv.inputRound();

        int [] scoreCars = new int[numberCar];

        rv.printIntroResult();

        playOneRound(round, scoreCars);
    }

    void playOneRound(int round, int[] scoreCars) {
        for (int i = 0; i < round; i++){
            playRacing(scoreCars);
            rv.printResult(scoreCars);
        }
    }

    private void playRacing(int[] scoreCars) {
        for (int i = 0; i < scoreCars.length; i++) {
            if (random.nextInt(10) >= 4) {
                scoreCars[i]++;
            }
        }
    }
}
