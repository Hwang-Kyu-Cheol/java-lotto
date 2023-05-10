package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.utils.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 이외의 숫자가 있으면, 예외가 발생합니다.")
    @Test
    void createLottoByNotInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBERS_SIZE);
        Lotto lotto = new Lotto(numbers);
        numbers.add(0);
        List<Integer> numbers1 = lotto.getNumbers();
        numbers1.add(1);
        System.out.println("numbers1 = " + numbers1);
        List<Integer> numbers2 = lotto.getNumbers();
        System.out.println("numbers2 = " + numbers2);
    }
}
