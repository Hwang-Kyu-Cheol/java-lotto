package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    /** 비즈니스 로직 **/
    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException();
        }
        if (!isAllInRange(winningNumbers) || !isInRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        if (hasDuplicatedNumbers(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isAllInRange(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (!isInRange(winningNumber)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInRange(int winningNumber) {
        if (Lotto.MIN_NUMBER <= winningNumber && winningNumber <= Lotto.MAX_NUMBER) {
            return true;
        }
        return false;
    }

    private boolean hasDuplicatedNumbers(List<Integer> winningNumbers, int bonusNumber) {
        boolean[] used = new boolean[46];
        for (int winningNumber : winningNumbers) {
            if (used[winningNumber]) {
                return true;
            }
            used[winningNumber] = true;
        }
        if (used[bonusNumber]) {
            return true;
        }
        return false;
    }
}
