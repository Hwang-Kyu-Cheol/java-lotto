package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Resolver {

    private static final String DELIMITER = ",";

    /**
     * 로또 구입 금액(String)을 int로 변환하는 기능
     * @param input
     * @return int
     */
    public static int resolveCost(String input) {
        Validator.validateCost(input);
        return Integer.parseInt(input);
    }

    /**
     * 로또 당첨 번호(String)를 List<Integer>로 변환하는 기능
     * @param input
     * @return List<Integer>
     */
    public static List<Integer> resolveWinningNumbers(String input) {
        Validator.validateWinningNumbers(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(winningNumber -> Integer.parseInt(winningNumber))
                .collect(Collectors.toList());
    }

    /**
     * 보너스 번호(String)을 int로 변환하는 기능
     * @param input
     * @return int
     */
    public static int resolveBonusNumber(String input) {
        Validator.validateBonusNumber(input);
        return Integer.parseInt(input);
    }
}
