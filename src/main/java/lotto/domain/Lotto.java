package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    /** 비즈니스 로직 **/
    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE || !isInRange(numbers) || hasDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private void sort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private boolean isInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDuplicatedNumbers(List<Integer> numbers) {
        boolean[] used = new boolean[46];
        for (int number : numbers) {
            if (used[number]) {
                return true;
            }
            used[number] = true;
        }
        return false;
    }
}
