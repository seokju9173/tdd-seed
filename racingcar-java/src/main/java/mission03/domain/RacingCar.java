package mission03.domain;

public class RacingCar {
    private int move;

    public RacingCar() {
        this.move = 0;
    }

    public int getMove() {
        return move;
    }

    public void updateMove(int move) { // set 명칭 사용X
        this.move = move;
    }
}
