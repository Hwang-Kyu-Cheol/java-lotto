package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.Win;

import java.util.Optional;

public class LottoCalculator {

    public static Optional<Win> calculate(Lotto lotto, Lotto winning, int bonusNumber) {
        int correctNumberCount = countCorrectNumber(lotto, winning);
        boolean isEqualBonus = lotto.contains(bonusNumber);
        return Win.find(correctNumberCount, isEqualBonus);
    }

    private static int countCorrectNumber(Lotto lotto, Lotto winning) {
        int count = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winning.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
