package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.utils.NumOverFourMove;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Cars 일급컬렉션 테스트")
class CarsTest {

    @Test
    @DisplayName("Car에 이름 부여한 리스트 생성")
    void carNamesInputTest() {
        String carNames = "pub,card,nex";
        Cars cars = new Cars(carNames);

        assertAll(
                () -> assertThat(cars.getCars().get(0).getCarName()).isEqualTo("pub"),
                () -> assertThat(cars.getCars().get(1).getCarName()).isEqualTo("card"),
                () -> assertThat(cars.getCars().get(2).getCarName()).isEqualTo("nex")
        );
    }

    @Test
    @DisplayName("특정 조건 발생 시 이동하는 테스트")
    void moveCarsTest() {
        Map<Integer, Cars> round = new HashMap<>();
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("pobi", new Distance(1), () -> true),
                        new Car("pobi", new Distance(4), () -> true),
                        new Car("pobi", new Distance(3), () -> false)
                )
        );

        round.put(1, cars.move());

        assertAll(
                () -> assertThat(round.get(1).getCars().get(0).getDistance()).isEqualTo(2),
                () -> assertThat(round.get(1).getCars().get(1).getDistance()).isEqualTo(5),
                () -> assertThat(round.get(1).getCars().get(2).getDistance()).isEqualTo(3)
        );
    }

}