package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.IntStream;
import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("새로 생성한 위치 객체가 1인지 확인")
    void positionCreateTest() {
        Position position = new Position();
        assertThat(position.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("새로 생성한 위치 객체 문자열 확인")
    void positionStringTest() {
        Position position = new Position();
        assertThat(position.positionString()).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차 객체 생성 후 위치 확인")
    void carCreateTest() {
        Car car = new Car(new MoveStrategyTrue());
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 객체 생성 후 위치 출력")
    void carStringTest() {
        Car car = new Car(new MoveStrategyTrue());
        assertThat(car.carPositionString()).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차 객체 생성 후 1칸 움직임")
    void carMoveTest() {
        Car car = new Car(new MoveStrategyTrue());
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
        assertThat(car.carPositionString()).isEqualTo("--");
    }

    @Test
    @DisplayName("자동차들 여러 대 생성 테스트")
    void carsCreateTest() {
        Cars cars2 = new Cars(new MoveStrategyTrue(), 2);
        assertThat(cars2.getCar(0).getPosition()).isEqualTo(1);
        assertThat(cars2.getCar(1).getPosition()).isEqualTo(1);
        assertThat(cars2.getCarList()).hasSize(2);

        cars2.getCar(0).move();
        List<String> carsStatus = ResultView.getCarsStatus(cars2.getCarList());
        assertThat(carsStatus.get(0)).isEqualTo("temp : --");
        assertThat(carsStatus.get(1)).isEqualTo("temp : -");
    }

    @Test
    @DisplayName("자동차들 0대 생성 테스트")
    void carsNotCreateTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(new MoveStrategyTrue(), 0));
    }

//    @Test
//    @DisplayName("자동차들 null 테스트")
//    void carsNullTest() {
//        Cars cars = new Cars(0);
//        cars.carList.add(null);
//        assertThatIllegalArgumentException().isThrownBy(() -> {
//            cars.getCar(0);
//        });
//    }

    @Test
    @DisplayName("이름 생성")
    void nameCreateTest() {
        Name name1 = new Name("name1");
        Name name2 = new Name("다섯글자닉");
        assertThat(name1.getCarName()).isEqualTo("name1");
        assertThat(name2.getCarName()).isEqualTo("다섯글자닉");
    }

    @Test
    @DisplayName("이름 생성 실패")
    void nameCreateFailTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Name name = new Name("여섯글자닉넴");
        });
    }

    @Test
    @DisplayName("이름들 ,로 분리")
    void namesSplitTest() {
        String string = "pobi,crong,honux";
        List<Name> names = NameSpliter.nameSplit(string);
        assertThat(names).hasSize(3);
        assertThat(names.get(0).getCarName())
                .isEqualTo("pobi");
        assertThat(names.get(1).getCarName())
                .isEqualTo("crong");
        assertThat(names.get(2).getCarName())
                .isEqualTo("honux");
    }

    @Test
    @DisplayName("이름들 분리 실패")
    void namesSplitFailTest() {
        String string = "1234,12345,123456,1234567";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<Name> names = NameSpliter.nameSplit(string);
        });
    }

    @Test
    @DisplayName("게임 승자 1명 테스트")
    void gameWinnerPersonTest() {
        String string = "pobi,crong,honux";
        Cars cars = new Cars(new MoveStrategyTrue(), string);
        IntStream.range(0, 4)
                .forEach(i -> cars.getCar(0).move());
        IntStream.range(0, 3)
                .forEach(i -> cars.getCar(1).move());
        IntStream.range(0, 2)
                .forEach(i -> cars.getCar(2).move());

        Game game = new Game();
        List<Car> winner = game.getWinner(cars);
        assertThat(winner).hasSize(1);
        assertThat(winner.get(0).getPosition())
                .isEqualTo(5);
        assertThat(winner.get(0).getName())
                .isEqualTo("pobi");
    }

    @Test
    @DisplayName("게임 승자 2명 테스트")
    void gameWinnerPeopleTest() {
        String string = "pobi,crong,honux";
        Cars cars = new Cars(new MoveStrategyTrue(), string);
        IntStream.range(0, 4)
                .forEach(i -> cars.getCar(0).move());
        IntStream.range(0, 4)
                .forEach(i -> cars.getCar(1).move());
        IntStream.range(0, 2)
                .forEach(i -> cars.getCar(2).move());

        Game game = new Game();
        List<Car> winner = game.getWinner(cars);
        assertThat(winner).hasSize(2);
        assertThat(winner.get(1).getPosition())
                .isEqualTo(5);
        assertThat(winner.get(1).getName())
                .isEqualTo("crong");
    }
}
