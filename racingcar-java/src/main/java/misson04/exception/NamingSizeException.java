package misson04.exception;

public class NamingSizeException extends IllegalArgumentException{

    public static final String MESSAGE_OVER_FIVE_CHARACTERS = "이름이 5글자가 넘습니다.";

    @Override
    public final String getMessage() {
        return MESSAGE_OVER_FIVE_CHARACTERS;
    }
}
