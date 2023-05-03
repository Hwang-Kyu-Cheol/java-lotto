package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Resolver;

import java.util.List;

public class Input {

    /**
     * 로또 구입 금액을 입력받고, 금액을 int로 변환하는 기능
     * @return int
     */
    public static int getCost() {
        String input = Console.readLine();
        return Resolver.resolveCost(input);
    }

    /**
     * 로또 당첨 번호를 입력받고, 번호를 List<Integer>로 변환하는 기능
     * @return List<Integer>
     */
    public static List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        return Resolver.resolveWinningNumbers(input);
    }

    /**
     * 보너스 번호를 입력받고, 번호를 int로 변환하는 기능
     * @return int
     */
    public static int getBonusNumber() {
        String input = Console.readLine();
        return Resolver.resolveBonusNumber(input);
    }
}
