package step3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Round {

    private Map<Integer, List<Car>> round = new HashMap<>();

    public Round(int round, List<Car> car) {
        this.round.put(round, car);
    }

    public void carMove() {
        System.out.println("");

        round.get(0).stream().forEach(i -> {
            i.move();
            i.printDistance();
        });
    }

}
