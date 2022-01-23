package mission02;

/**
 * StringUtils는 문자열을 나눠주고, 문자열 돌려주는 Utils
 */
public class StringUtils {
    private final String[] expression;
    public static final String SPLIT_VAL = " ";

    public StringUtils(String expression){
        this.expression = expression.split(SPLIT_VAL);
    }

    public String[] getExpression(){
        return expression;
    }

    public int getCharacterToNumber(String character) {
        final String regExp = "^[0-9]*$";

        if (character.matches(regExp)){
            return Integer.parseInt(character);
        }
        throw new NumberFormatException("cannot Read Expression");
    }
}
