package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    /**
     * 로또 구입 금액을 입력받고, 금액을 int로 반환하는 기능
     * @return int
     */
    public static int getCost() {
        String input = Console.readLine();
        return Resolver.resolveCost(input);
    }
}
