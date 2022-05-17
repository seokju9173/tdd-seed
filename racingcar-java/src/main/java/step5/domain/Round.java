package step5.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Round {
    private final Map<Integer, Cars> round;

    public Round(final Map<Integer, Cars> round) {
        this.round = round;
    }

    public Round(final int roundNum, final Cars cars) {
        this.round = new HashMap<>();
        this.round.put(roundNum, cars);
    }

    public void add(final int roundNum, final Cars cars) {
        round.put(roundNum, cars);
    }

    public List<String> findWinners() {
        int attempt = round.size() - 1;
        return round.get(attempt).winner();
    }

    public Map<Integer, Cars> getRound() {
        return Collections.unmodifiableMap(round);
    }
}
