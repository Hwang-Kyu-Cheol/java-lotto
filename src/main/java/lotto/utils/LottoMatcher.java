package lotto.utils;

import lotto.constant.Winning;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.Optional;

public class LottoMatcher {

    public static Optional<Winning> findWinning(WinningLotto winningLotto, Lotto lotto) {
        int equalWinningNumbersCount = countWinningNumbers(winningLotto, lotto);
        boolean equalBonusNumber = hasBonusNumber(winningLotto, lotto);
        return Winning.findWinning(equalWinningNumbersCount, equalBonusNumber);
    }

    /** 비즈니스 로직 **/
    private static int countWinningNumbers(WinningLotto winningLotto, Lotto lotto) {
        int winningNumbersCount = 0;
        for (int i = 0; i < Lotto.NUMBERS_SIZE; i++) {
            if (winningLotto.contains(lotto.get(i))) {
                winningNumbersCount++;
            }
        }
        return winningNumbersCount;
    }

    private static boolean hasBonusNumber(WinningLotto winningLotto, Lotto lotto) {
        return lotto.contains(winningLotto.getBonusNumber());
    }
}
