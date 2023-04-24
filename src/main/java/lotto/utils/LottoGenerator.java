package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    /**
     * 로또 생성기(1~45, 6개 숫자, 정렬)
     * @return Lotto
     */
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
