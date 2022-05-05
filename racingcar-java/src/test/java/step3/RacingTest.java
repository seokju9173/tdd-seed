package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Cars;
import step3.view.Utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@DisplayName("레이싱 테스트")
class RacingTest {
    Racing racing = new Racing();
    Utils.OutputView outputView = new Utils.OutputView();

    @Test
    @DisplayName("입력값 넣기 테스트")
    void testRacing() {
        String input = "3\n5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        racing.raceStart();
    }

    @Test
    @DisplayName("Car에 값 넣고 이동하기")
    void useCarObjectTest() {
        Cars cars = new Cars(3);

        outputView.outputMoveCarPosition(cars);
        cars.getCars().get(0).move();
        outputView.outputMoveCarPosition(cars);
    }

}