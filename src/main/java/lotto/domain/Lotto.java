package lotto.domain;

import java.util.ArrayList;
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
        this.numbers = numbers;
    }

    public int get(int index) {
        return numbers.get(index);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    /** 비즈니스 로직 **/
    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
        if (!isAllInRange(numbers)) {
            throw new IllegalArgumentException();
        }
        if (hasDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isAllInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!isInRange(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInRange(int number) {
        if (MIN_NUMBER <= number && number <= MAX_NUMBER) {
            return true;
        }
        return false;
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
