package mission02.exception;

/**
 * 받은 문자가 숫자형 문자가 아닐 때
 */

public class FormatException extends NumberFormatException{
    private final String EXCEPTION_MESSAGE = "format is not number";

    @Override
    public final String getMessage() {
        return EXCEPTION_MESSAGE;
    }
}
