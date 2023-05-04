package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.List;

public class WinningLotto {

    private static final int NUMBERS_SIZE = 6;

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    /** 비즈니스 로직 **/
    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS);
        }
        if (!isAllInRange(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS);
        }
        if (!isInRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER);
        }
        if (hasDuplicatedNumbers(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS);
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
