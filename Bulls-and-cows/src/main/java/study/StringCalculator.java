package study;

import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static int calculate(String input, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(input, delimiter);
        InputValidator.checkSize(tokenizer.countTokens());
        return calculate(tokenizer);
    }

    private static int calculate(StringTokenizer tokenizer) {
        int baseValue = parseInt(tokenizer.nextToken());
        while (tokenizer.hasMoreTokens()) {
            String operation = tokenizer.nextToken();
            String number = tokenizer.nextToken();

            baseValue = OperationType.getOperator(operation)
                    .apply(baseValue, parseInt(number));
        }
        return baseValue;
    }
}
