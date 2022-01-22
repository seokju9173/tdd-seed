public class RacingMain {

    public static void main(String[] args) {
        InputView iv = new InputView();
        int numberCars = iv.inputNumberCar();
        int round = iv.inputRound();

        RacingCar rc = new RacingCar(numberCars);

        ResultView rv = new ResultView();
        rv.printIntroResult();

        for (int i = 0; i < round; i++){
            rc.playOneRound(rc.getCars());
            rv.printResult(rc.getCars());
        }
    }
}
