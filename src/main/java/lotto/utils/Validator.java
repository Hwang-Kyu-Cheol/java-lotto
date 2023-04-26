package lotto.utils;

import lotto.domain.Lotto;

public class Validator {

    public static void validateCost(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException();
        }
        int cost = Integer.parseInt(input);
        if (!isPositive(cost)) {
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

    private static boolean isPositive(int input) {
        if (input > 0) {
            return true;
        }
        return false;
    }
}
