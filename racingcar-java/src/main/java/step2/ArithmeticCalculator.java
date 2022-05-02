package step2;

public class ArithmeticCalculator {

    public int add(final int x, final int y) {
        return x + y;
    }

    public int minus(final int x, final int y) {
        return x - y;
    }

    public int multiplication(final int x, final int y) {
        return x * y;
    }

    public int division(final int x, final int y) {
        checkDivision(y);
        return x / y;
    }

    private void checkDivision(final int y) {
        if(y == 0){
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}
