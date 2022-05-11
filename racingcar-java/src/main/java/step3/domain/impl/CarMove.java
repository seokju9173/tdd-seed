package step3.domain.impl;

import step3.domain.Car;

public interface CarMove {
    public int move(Car car, String name);

    public int move(Car car, int targetBound);
}
