package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Cars;
import step3.view.OutputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@DisplayName("레이싱 테스트")
class RacingTest {
    Racing racing = new Racing();
    OutputView outputView = new OutputView();

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
        Cars cars = new Cars(IntStream.range(0, 3)
                .mapToObj(Car::new)
                .collect(Collectors.toList()));

        outputView.outputMoveCarPosition(cars);
        cars.getCars().get(0).move();
        outputView.outputMoveCarPosition(cars);
    }

    @Test
    @DisplayName("경주 기능 테스트")
    void racingLogicTest() {
        Cars cars = new Cars(IntStream.range(0, 3)
                .mapToObj(Car::new)
                .collect(Collectors.toList()));

        outputView.outputMoveCarPosition(cars);

        for (Car car: cars.getCars()) {
            car.move();
            outputView.outputMoveCarPosition(cars);
            System.out.println("");
        }
    }

}