package misson04.utils;

import misson04.exception.FormatException;

public class Validator {

    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_FIVE = 5;

    public static int stringToNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new FormatException();
        }
    }

    public static boolean isEmptyAndIsNull(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isCorrectNameLength(String name) {
        return name.length() < NUMBER_ONE || name.length() >= NUMBER_FIVE;
    }
}
