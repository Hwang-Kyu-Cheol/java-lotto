package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class LottoGenerator {

    /**
     * 로또를 생성하는 기능
     * @return Lotto
     */
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBERS_SIZE);
        return new Lotto(numbers);
    }
}
