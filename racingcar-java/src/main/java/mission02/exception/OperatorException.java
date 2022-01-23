package mission02.exception;

/**
 * 받은 문자가 +,-,*,/ 가 아닐 때
 */

public class OperatorException extends IllegalArgumentException{
    private final String EXCEPTION_MESSAGE = "operation is not arithmetic operation";

    @Override
    public final String getMessage() {
        return EXCEPTION_MESSAGE;
    }
}
