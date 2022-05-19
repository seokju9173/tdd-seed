package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Round 테스트")
class RoundTest {

    @Test
    @DisplayName("Round 객체 테스트")
    void createRoundObjectTest(){
        Cars cars = new Cars(Arrays.asList(
                new Car("pobi", new Distance(1), () -> true),
                new Car("pobi", new Distance(1), () -> false),
                new Car("pobi", new Distance(2), () -> true)
        ));

        Round round = new Round(0, cars);
        round.add(1,cars.move());

        assertAll(
                () -> assertThat(round.getRound().get(1).getCars().get(0).getDistance()).isEqualTo(2),
                () -> assertThat(round.getRound().get(1).getCars().get(1).getDistance()).isEqualTo(1),
                () -> assertThat(round.getRound().get(1).getCars().get(2).getDistance()).isEqualTo(3)
        );
    }
}