package step3.domain;

import java.util.HashMap;
import java.util.Map;

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

    public int getRoundSize() {
        return round.size();
    }
}
