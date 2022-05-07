package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Cars;
import step3.view.Utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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
    @DisplayName("Car 이름 가져오기")
    void getCarName(){
        String carNames = "pobi,crong,honux";

        Cars cars = new Cars(carNames);

        assertAll(
                () -> assertThat(cars.getCars().get(0).getCarName()).isEqualTo("pobi"),
                () -> assertThat(cars.getCars().get(1).getCarName()).isEqualTo("crong")
        );
    }

}