package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

class CarTest {

    Car c;

    @BeforeEach
    void init() {
        c = new Car();
    }

    @Test
    @DisplayName("move 성공 테스트")
    void moveTest(){
        int position = c.getPosition();
        c.move(5);
        assertThat(c.getPosition()).isEqualTo(position+1);
    }

    @Test
    @DisplayName("move 실패 테스트")
    void moveFailTest(){
        int position = c.getPosition();
        c.move(2);
        assertThat(c.getPosition()).isEqualTo(position);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10, 15})
    @DisplayName("move 파라미터 에러 테스트")
    void moveInvalidErrorTest(int numberCar) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> c.move(numberCar))
                .withMessageMatching("0에서 9사이의 숫자여야 합니다");
    }
}