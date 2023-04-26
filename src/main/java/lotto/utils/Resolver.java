package lotto.utils;

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
}
