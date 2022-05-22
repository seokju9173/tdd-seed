package racingcar5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("위치 객체 테스트")
    void positionCreateTest() {
        Position position1 = new Position();
        Position position2 = new Position(2);
        Position position3 = new Position(3);
        position3.increase();
        assertAll(
                () -> assertThat(position1.getDistance()).isEqualTo(1),
                () -> assertThat(position2.getDistance()).isEqualTo(2),
                () -> assertThat(position3.getDistance()).isEqualTo(4)
        );
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void carCreateTest() {
        Car car = new Car(new AlwaysMoveStrategy(), "pobi");
        assertAll(
                () -> assertThat(car.getName()).isEqualTo("pobi"),
                () -> assertThat(car.getPosition()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void carMoveTest() {
        Car car = new Car(new AlwaysMoveStrategy());
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("이름 분할 테스트")
    void nameSplitTest() {
        List<String> nameStrings = NameSpliter.nameSplit("pobi,crong,honux");
        assertAll(
                () -> assertThat(nameStrings.get(0)).isEqualTo("pobi"),
                () -> assertThat(nameStrings.get(2)).isEqualTo("honux"),
                () -> assertThat(nameStrings).hasSize(3)
        );
    }

    @Test
    @DisplayName("이름 분할 실패 테스트")
    void nameSplitFailTest() {
        assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> NameSpliter.nameSplit(null)),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> NameSpliter.nameSplit(""))
        );
    }

    @Test
    @DisplayName("Cars 클래스 테스트")
    void carsCreateTest() {
        Cars cars = new Cars("pobi,crong,honux");
        cars.moveCars();
        assertAll(
                () -> assertThat(cars.getCar(0).getName()).isEqualTo("pobi"),
                () -> assertThat(cars.getCar(1).getPosition()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("Cars 클래스 실패 테스트")
    void carsFailTest() {
        Cars cars = new Cars("pobi");
        assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> cars.getCar(-1)),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> cars.getCar(2))
        );
    }
}
