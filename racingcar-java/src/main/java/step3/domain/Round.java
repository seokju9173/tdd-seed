package step3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Round {
    private final Map<Integer, Cars> round;

    public Round(final int round, final Cars cars) {
        this.round = new HashMap<Integer, Cars>();
        this.round.put(round, cars);
    }

    public void add(final int round, final Cars cars) {
        this.round.put(round, cars);
    }

    public Map<Integer, Cars> getRound() {
        return round;
    }

    public List<String> getWinners() {
        int size = round.size() - 1;
        return round.get(size).winners()
                .stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
