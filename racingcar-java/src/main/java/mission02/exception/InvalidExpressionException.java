package mission02.exception;

/**
 * 마지막에 부등호로 끝나 문장의 끝맺음이 제대로 안될 때
 */

public class InvalidExpressionException extends IllegalArgumentException{
    private final String EXCEPTION_MESSAGE = "expression is invalid expression";

    @Override
    public final String getMessage() {
        return EXCEPTION_MESSAGE;
    }
}
