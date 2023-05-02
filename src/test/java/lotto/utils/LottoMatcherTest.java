package lotto.utils;

import lotto.constant.Winning;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class LottoMatcherTest {

    @DisplayName("6개가 일치했을 경우, 1등입니다.")
    @Test
    void winFirst() {
        //given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        Optional<Winning> winning = LottoMatcher.findWinning(winningLotto, lotto);

        //then
        assertThat(winning).isPresent();
        assertThat(winning.get()).isEqualTo(Winning.FIRST);
    }

    @DisplayName("5개가 일치하고 보너스 볼이 일치했을 경우, 2등입니다.")
    @Test
    void winSecond() {
        //given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 8), 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        Optional<Winning> winning = LottoMatcher.findWinning(winningLotto, lotto);

        //then
        assertThat(winning).isPresent();
        assertThat(winning.get()).isEqualTo(Winning.SECOND);
    }

    @DisplayName("5개가 일치하고 보너스 볼이 일치하지 않을 경우, 3등입니다.")
    @Test
    void winThird() {
        //given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 8), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        Optional<Winning> winning = LottoMatcher.findWinning(winningLotto, lotto);

        //then
        assertThat(winning).isPresent();
        assertThat(winning.get()).isEqualTo(Winning.THIRD);
    }

    @DisplayName("4개가 일치했을 경우, 4등입니다.")
    @Test
    void winFourth() {
        //given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 9, 8), 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        Optional<Winning> winning = LottoMatcher.findWinning(winningLotto, lotto);

        //then
        assertThat(winning).isPresent();
        assertThat(winning.get()).isEqualTo(Winning.FOURTH);
    }

    @DisplayName("3개가 일치했을 경우, 5등입니다.")
    @Test
    void winFifth() {
        //given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 10, 9, 8), 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        Optional<Winning> winning = LottoMatcher.findWinning(winningLotto, lotto);

        //then
        assertThat(winning).isPresent();
        assertThat(winning.get()).isEqualTo(Winning.FIFTH);
    }

    @DisplayName("3개 미만으로 일치했을 경우, 당첨되지 못합니다")
    @Test
    void winNothing() {
        //given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 11, 10, 9, 8), 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        Optional<Winning> winning = LottoMatcher.findWinning(winningLotto, lotto);

        //then
        assertThat(winning).isNotPresent();
    }
}