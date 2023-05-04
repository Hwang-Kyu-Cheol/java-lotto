package lotto.utils;

import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;

public class Validator {

    private static final String DELIMITER = ",";

    /**
     * 로또 구입 금액을 검증하는 기능
     * @param input
     * @throws IllegalArgumentException
     */
    public static void validateCost(String input) throws IllegalArgumentException {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_PRICE);
        }
        int cost = Integer.parseInt(input);
        if (!isPositive(cost) || !isDividedByLottoPrice(cost)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_PRICE);
        }
    }

    /**
     * 당첨 번호들을 검증하는 기능
     * @param input
     * @throws IllegalArgumentException
     */
    public static void validateWinningNumbers(String input) throws IllegalArgumentException {
        String[] winningNumbers = input.split(DELIMITER);
        if (winningNumbers.length != Lotto.SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS);
        }
        for (String winningNumber : winningNumbers) {
            validateLottoNumber(winningNumber);
        }
    }

    /**
     * 보너스 번호를 검증하는 기능
     * @param input
     * @throws IllegalArgumentException
     */
    public static void validateBonusNumber(String input) throws IllegalArgumentException {
        validateLottoNumber(input);
    }

    /** 비즈니스 로직 **/
    private static void validateLottoNumber(String input) throws IllegalArgumentException {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS);
        }
        int winningNumber = Integer.parseInt(input);
        if (!isInRange(winningNumber, Lotto.MIN_NUMBER, Lotto.MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS);
        }
    }

    private static boolean isInRange(int input, int min, int max) {
        if (min <= input && input <= max) {
            return true;
        }
        return false;
    }
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

    private static boolean isDividedByLottoPrice(int input) {
        if (input % Lotto.PRICE == 0) {
            return true;
        }
        return false;
    }
}
