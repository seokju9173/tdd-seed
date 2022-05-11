package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Cars;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("레이싱 테스트")
class RacingTest {

    @Test
    @DisplayName("자동차 이름 비어있을 때 오류 발생 테스트")
    void carNameIsNullTest() {
        assertThatThrownBy(() -> new Cars(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Car 이름 가져오기")
    void getCarName() {
        String carNames = "pobi,crong,honux";

        Cars cars = new Cars(carNames);

        assertAll(
                () -> assertThat(cars.getCars().get(0).getCarName()).isEqualTo("pobi"),
                () -> assertThat(cars.getCars().get(1).getCarName()).isEqualTo("crong")
        );
    }
}