package lotto.utils;

public class Validator {

    public static void validateCost(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException();
        }
    }

    /** 비즈니스 로직 **/
    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
