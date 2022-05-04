package step3;

import step3.collections.Car;
import step3.collections.Round;
import step3.io.Input;
import step3.io.Output;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    public void raceStart() {

        Output output = new Output();
        Input input = new Input();

        output.outputHowManyCar();
        int count = input.inputRaceData();
        output.outputHowManyRacingAttempt();

        Round round = new Round(0, IntStream.range(0, count)
                .mapToObj(Car::new)
                .collect(Collectors.toList()));

        IntStream.range(0, input.inputRaceData())
                .forEach(i -> round.carMove());
    }
}
