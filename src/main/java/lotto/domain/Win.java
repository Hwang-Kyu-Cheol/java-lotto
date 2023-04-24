package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Win {

    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4,false,50000),
    FIFTH(5, 3, false,5000);

    private int rank;
    private int correctNumberCount;
    private boolean mustEqualBonus;
    private int prize;

    Win(int rank, int correctNumberCount, boolean mustEqualBonus, int prize) {
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

    public int getPrize() {
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
