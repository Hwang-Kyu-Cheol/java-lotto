package lotto.constant;

public enum WinningCriteria {

    FIRST(Winning.FIRST, 6, false),
    SECOND(Winning.SECOND, 5, true),
    THIRD(Winning.THIRD, 5, false),
    FOURTH(Winning.FOURTH, 4, false),
    FIFTH(Winning.FIFTH, 3, false);

    private Winning winning;
    private int equalWinningNumbersCount;
    private boolean mustEqualBonusNumber;

    WinningCriteria(Winning winning, int equalWinningNumbersCount, boolean mustEqualBonusNumber) {
        this.winning = winning;
        this.equalWinningNumbersCount = equalWinningNumbersCount;
        this.mustEqualBonusNumber = mustEqualBonusNumber;
    }

    public Winning getWinning() {
        return winning;
    }

    public int getEqualWinningNumbersCount() {
        return equalWinningNumbersCount;
    }

    public boolean isMustEqualBonusNumber() {
        return mustEqualBonusNumber;
    }
}
