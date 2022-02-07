package misson04.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingInfo {

    private final static String postfix = "가 최종 우승했습니다";

    private final RacingCourse racingCourse;

    public RacingInfo(RacingCourse racingCourse) {
        this.racingCourse = racingCourse;
    }

    public String getRacingWinner(){
        int distance = getMaxDistance();
        List<String> winners = getRacingCourseCars().stream().filter(i -> i.getMovedDistance() == distance)
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());

        return String.join(",", winners) + postfix;
    }

    private List<RacingCar> getRacingCourseCars(){
        return racingCourse.getCars();
    }

    private int getMaxDistance(){
        return getRacingCourseCars().stream()
                .mapToInt(RacingCar::getMovedDistance)
                .max()
                .getAsInt();
    }
}
