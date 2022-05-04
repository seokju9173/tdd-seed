package step3.collections;

import java.util.HashMap;
import java.util.Map;

public class Round {

    private Map<Integer, Car> round =new HashMap<>();

    public Round(int round , Car car){
        this.round.put(round, car);
    }

    public void printRound(){
        round.forEach((i, j) -> System.out.println(i +" "+ j));
    }
}
