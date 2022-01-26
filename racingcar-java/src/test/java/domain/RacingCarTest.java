package domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    @DisplayName("RacingCar 생성 확인 테스트")
    void setCarsTest() {
        RacingCar rc= new RacingCar("pobi,crong,houx");
        assertThat(rc.getCars().size()).isEqualTo(3);
    }
}