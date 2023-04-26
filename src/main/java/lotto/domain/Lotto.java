package lotto.domain;

import java.util.List;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    /** 비즈니스 로직 **/
    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE || hasDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
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
