package misson04.exception;


public class FormatException extends NumberFormatException {
    private static final String EXCEPTION_MESSAGE = "숫자의 형태가 아닙니다.";

    @Override
    public final String getMessage() {
        return EXCEPTION_MESSAGE;
    }
}
