package lotto.utils;

import lotto.constant.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Resolver {

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
        return Arrays.stream(input.split(Constant.DELIMITER))
                .map(winningNumber -> Integer.parseInt(winningNumber))
                .collect(Collectors.toList());
    }
}
