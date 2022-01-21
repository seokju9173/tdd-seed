import org.junit.jupiter.api.Test;

class RacingCarTest {

    RacingCar rc = new RacingCar();

    @Test
    void racingMainTest() {
        int [] scoreCars = new int[3];
        rc.playOneRound(5, scoreCars);
    }
}