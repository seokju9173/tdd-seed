package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@DisplayName("레이싱 테스트")
class RacingTest {
    Racing racing = new Racing();

    @Test
    @DisplayName("입력값 넣기 테스트")
    void testRacing(){
        String input = "3\n5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //racing.racingCar();
    }

    @Test
    @DisplayName("입력값 넣기 테스트")
    void testRacing2(){
        String input = "3\n5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        racing.raceStart();
    }
}