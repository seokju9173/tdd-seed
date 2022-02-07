package misson04.exception;

public class NamingEmptyException extends IllegalArgumentException{

    public static final String MESSAGE_EMPTY_STRING = "이름이 비어있습니다.";

    @Override
    public final String getMessage() {
        return MESSAGE_EMPTY_STRING;
    }
}