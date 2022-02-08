package step04;

import misson04.domain.RacingCar;
import misson04.domain.RacingCourse;
import misson04.domain.RacingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingInfoTest {

    private static final String name1 = "아수라1";
    private static final String name2 = "아수라2";
    private static final String name3 = "아수라3";

    @Test
    @DisplayName("올바르게 자동차의 최대로 이동한 거리를 뽑아 오는지")
    void getMaximumCarsMovedDistance() {
        RacingCar rc1 = new RacingCar(name1, 1);
        RacingCar rc2 = new RacingCar(name2, 2);
        RacingCar rc3 = new RacingCar(name3, 3);

        List<RacingCar> cars = new ArrayList<>();
        cars.add(rc1);
        cars.add(rc2);
        cars.add(rc3);

        RacingCourse racingCourse = new RacingCourse(cars);
        RacingInfo racingInfo = new RacingInfo(racingCourse);

        assertThat(racingInfo.getMaxDistance()).isEqualTo(3);
    }

    @Test
    @DisplayName("경주에서 우승자가 한명일 때")
    void winnerPeopleSizeIsOne() {
        RacingCar rc1 = new RacingCar(name1, 5);
        RacingCar rc2 = new RacingCar(name2, 6);
        RacingCar rc3 = new RacingCar(name3, 7);

        List<RacingCar> cars = new ArrayList<>();
        cars.add(rc1);
        cars.add(rc2);
        cars.add(rc3);

        RacingCourse racingCourse = new RacingCourse(cars);
        RacingInfo racingInfo = new RacingInfo(racingCourse);

        assertThat(racingInfo.getRacingWinner()).isEqualTo(name3);
    }

    @Test
    @DisplayName("경주에서 우승자가 여러명일 때")
    void winnerPeopleSizeMoreThanOne() {
        RacingCar rc1 = new RacingCar(name1, 5);
        RacingCar rc2 = new RacingCar(name2, 6);
        RacingCar rc3 = new RacingCar(name3, 6);

        List<RacingCar> cars = new ArrayList<>();
        cars.add(rc1);
        cars.add(rc2);
        cars.add(rc3);

        RacingCourse racingCourse = new RacingCourse(cars);
        RacingInfo racingInfo = new RacingInfo(racingCourse);

        assertThat(racingInfo.getRacingWinner()).isEqualTo(name2 + "," + name3);
    }
}
