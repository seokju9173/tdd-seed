package step3.collections;

import java.util.Map;

public class Cars {
    Map<Integer, String> cars;

    public Cars(final int number , final String distance){
        cars.put(number, distance);
    }

}
