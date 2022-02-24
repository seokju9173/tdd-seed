package study;

import static study.Constant.Integer.ONE;

public class InputValidator {

    public static void checkSize(int length) {
        if ((length & ONE) != ONE) {
            throw new IllegalArgumentException();
        }
    }
}
