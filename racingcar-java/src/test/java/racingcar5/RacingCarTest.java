package racingcar5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.IntStream;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("위치 객체 생성 테스트")
    void positionCreateTest() {
        Position position1 = new Position();
        Position position2 = new Position(2);
        assertAll(
                () -> assertThat(position1.getDistance()).isEqualTo(1),
                () -> assertThat(position2.getDistance()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("위치 객체 증가 테스트")
    void positionIncreaseTest() {
        Position position = new Position();
        position.increase();
        assertThat(position.getDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void carCreateTest() {
        Car car = new Car(new AlwaysMoveStrategy(), "pobi");
//        assertAll(
//                () -> assertThat(car.getName()).isEqualTo("pobi"),
//                () -> assertThat(car.getPosition()).isEqualTo(1)
//        );
        assertThat(car)
                .usingRecursiveComparison()
                .ignoringFields("moveStrategy")
                .isEqualTo(new Car(() -> true, "pobi", 1));
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void carMoveTest() {
        Car car = new Car(new AlwaysMoveStrategy());
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("Cars 클래스 테스트")
    void carsCreateTest() {
        Cars cars = new Cars(new AlwaysMoveStrategy(), "pobi,crong,honux");
        cars.moveCars();
        assertAll(
                () -> assertThat(cars.getCar(0).getName()).isEqualTo("pobi"),
                () -> assertThat(cars.getCar(1).getPosition()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("Cars 클래스 실패 테스트")
    void carsFailTest() {
        Cars cars = new Cars(new AlwaysMoveStrategy(), "pobi");
        assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> cars.getCar(-1)),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> cars.getCar(2)),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> new Cars(new AlwaysMoveStrategy(), ""))
        );
    }

    @Test
    @DisplayName("승자 1명 테스트")
    void winnerTest() {
        Cars cars = new Cars(new AlwaysMoveStrategy(), "pobi,crong,honux");
        IntStream.range(0, 5)
                .forEach(i -> cars.getCar(0).move());
        IntStream.range(0, 3)
                .forEach(i -> cars.getCar(1).move());
        List<Car> winner = Game.findWinner(cars);
        assertAll(
                () -> assertThat(winner).hasSize(1),
                () -> assertThat(winner.get(0).getPosition()).isEqualTo(6),
                () -> assertThat(winner.get(0).getName()).isEqualTo("pobi")
        );
    }

    @Test
    @DisplayName("승자 2명 테스트")
    void winnersTest() {
        Cars cars = new Cars(new AlwaysMoveStrategy(), "pobi,crong,honux");
        IntStream.range(0, 3)
                .forEach(i -> cars.getCar(0).move());
        IntStream.range(0, 3)
                .forEach(i -> cars.getCar(2).move());
        List<Car> winner = Game.findWinner(cars);
        assertAll(
                () -> assertThat(winner).hasSize(2),
                () -> assertThat(winner.get(1).getPosition()).isEqualTo(4),
                () -> assertThat(winner.get(1).getName()).isEqualTo("honux")
        );
    }
}
