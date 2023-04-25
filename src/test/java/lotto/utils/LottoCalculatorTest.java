package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.Win;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoCalculatorTest {

    @DisplayName("숫자 6개가 일치했을 경우, 보너스 여부와 관계없이 1등입니다.")
    @Test
    void winFirst() {
        //given
        Lotto user = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto winning = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        int bonusNumber = 7;

        //when
        Optional<Win> win = LottoCalculator.calculate(user, winning, bonusNumber);

        //then
        assertThat(win).isPresent();
        assertThat(win.get()).isEqualTo(Win.FIRST);
    }

    @DisplayName("숫자 5개가 일치하고, 보너스 숫자가 일치했을 경우 2등입니다.")
    @Test
    void winSecond() {
        //given
        Lotto user = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto winning = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        int bonusNumber = 6;

        //when
        Optional<Win> win = LottoCalculator.calculate(user, winning, bonusNumber);

        //then
        assertThat(win).isPresent();
        assertThat(win.get()).isEqualTo(Win.SECOND);
    }

    @DisplayName("숫자 5개가 일치하고, 보너스 숫자가 일치하지 않을 경우 3등입니다.")
    @Test
    void winThird() {
        //given
        Lotto user = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto winning = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        int bonusNumber = 8;

        //when
        Optional<Win> win = LottoCalculator.calculate(user, winning, bonusNumber);

        //then
        assertThat(win).isPresent();
        assertThat(win.get()).isEqualTo(Win.THIRD);
    }

    @DisplayName("숫자 4개가 일치했을 경우, 보너스 여부와 상관없이 4등입니다.")
    @Test
    void winFourth() {
        //given
        Lotto user = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto winning = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 7)));
        int bonusNumber = 6;

        //when
        Optional<Win> win = LottoCalculator.calculate(user, winning, bonusNumber);

        //then
        assertThat(win).isPresent();
        assertThat(win.get()).isEqualTo(Win.FOURTH);
    }

    @DisplayName("숫자 3개 미만으로 일치했을 경우, 보너스 여부와 상관없이 등수가 없습니다.")
    @Test
    void winNothing() {
        //given
        Lotto user = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto winning = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 10, 11, 9, 7)));
        int bonusNumber = 6;

        //when
        Optional<Win> win = LottoCalculator.calculate(user, winning, bonusNumber);

        //then
        assertThat(win).isNotPresent();
    }
}