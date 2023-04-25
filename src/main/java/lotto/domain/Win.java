package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

public enum Win {

    FIRST(1, 6, false, new BigDecimal(2000000000)),
    SECOND(2, 5, true, new BigDecimal(30000000)),
    THIRD(3, 5, false, new BigDecimal(1500000)),
    FOURTH(4, 4,false, new BigDecimal(50000)),
    FIFTH(5, 3, false, new BigDecimal(5000));

    private int rank;
    private int correctNumberCount;
    private boolean mustEqualBonus;
    private BigDecimal prize;

    Win(int rank, int correctNumberCount, boolean mustEqualBonus, BigDecimal prize) {
        this.rank = rank;
        this.correctNumberCount = correctNumberCount;
        this.mustEqualBonus = mustEqualBonus;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }

    public boolean isMustEqualBonus() {
        return mustEqualBonus;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    /**
     * 당첨된 등수를 판단하는 기능
     * @param correctNumberCount
     * @param isEqualBonus
     * @return Optional<Win>
     */
    public static Optional<Win> find(int correctNumberCount, boolean isEqualBonus) {
        return Arrays.stream(Win.values())
                .filter(win -> {
                    if (win.getCorrectNumberCount() == correctNumberCount) {
                        if (win.isMustEqualBonus() && !isEqualBonus) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                })
                .findAny();
    }
}
