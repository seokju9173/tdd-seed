package mission02.exception;

/**
 * 0으로 나눌 때, Exception
 */

public class DividedException extends ArithmeticException{
    private final String EXCEPTION_MESSAGE = "cannot be divided by zero";

    @Override
    public final String getMessage() {
        return EXCEPTION_MESSAGE;
    }
    /**
     * 나타내기 힘든 것만을 커스텀하자.
     */
}
