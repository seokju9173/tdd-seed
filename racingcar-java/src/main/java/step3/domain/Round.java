package step3.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Round implements Cloneable{

    private final Map<Integer, Cars> round = new HashMap<>();

    public Round(int number , Cars cars) {
        round.put(number, cars);
    }

    public Map<Integer, Cars> getRound() {
        return Collections.unmodifiableMap(round);
    }

    public Round clone() throws CloneNotSupportedException{
        return (Round) super.clone();
    }
}
