package domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    @DisplayName("car 생성 확인 테스트")
    void setCarsTest() {
        int numberCar = 5;
        RacingCar rc= new RacingCar(numberCar);
        assertThat(rc.getCars().size()).isEqualTo(numberCar);
    }
}