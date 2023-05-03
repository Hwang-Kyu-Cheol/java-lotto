package lotto.constant;

import java.util.Arrays;
import java.util.Optional;

public enum Winning {

    FIRST(1, 2_000_000_000, 6, false),
    SECOND(2, 30_000_000, 5, true),
    THIRD(3, 1_500_000, 5, false),
    FOURTH(4, 50_000, 4, false),
    FIFTH(5, 5_000, 3, false);

    private int rank;
    private int prize;
    private int equalWinningNumbersCount;
    private boolean mustEqualBonusNumber;

    Winning(int rank, int prize, int equalWinningNumbersCount, boolean mustEqualBonusNumber) {
        this.rank = rank;
        this.prize = prize;
        this.equalWinningNumbersCount = equalWinningNumbersCount;
        this.mustEqualBonusNumber = mustEqualBonusNumber;
    }

    public static Optional<Winning> findWinning(int equalWinningNumbersCount, boolean equalBonusNumber) {
        return Arrays.stream(values())
                .filter(winning -> winning.equalWinningNumbersCount == equalWinningNumbersCount)
                .filter(winning -> {
                    if (winning.mustEqualBonusNumber && !equalBonusNumber) {
                        return false;
                    }
                    return true;
                })
                .findAny();
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }
}
