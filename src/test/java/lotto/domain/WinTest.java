package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinTest {

    @DisplayName("6개가 일치했을 경우, 보너스 일치 여부와 상관 없이 1등입니다.")
    @Test
    void winFirst() {
        //given & when
        Win win1 = Win.find(6, true).get();
        Win win2 = Win.find(6, false).get();

        //then
        assertThat(win1).isEqualTo(Win.FIRST);
        assertThat(win2).isEqualTo(Win.FIRST);
    }

    @DisplayName("5개가 일치했을 경우, 보너스가 일치할 경우만 2등입니다.")
    @Test
    void winSecond() {
        //given & when
        Win win1 = Win.find(5, true).get();
        Win win2 = Win.find(5, false).get();

        //then
        assertThat(win1).isEqualTo(Win.SECOND);
        assertThat(win2).isNotEqualTo(Win.SECOND);
    }

    @DisplayName("5개가 일치했을 경우, 보너스가 불일치할 경우 3등입니다.")
    @Test
    void winThird() {
        //given & when
        Win win = Win.find(5, false).get();

        //then
        assertThat(win).isEqualTo(Win.THIRD);
    }

    @DisplayName("4개가 일치했을 경우, 보너스 일치 여부와 상관없이 4등입니다.")
    @Test
    void winFourth() {
        //given & when
        Win win1 = Win.find(4, true).get();
        Win win2 = Win.find(4, false).get();

        //then
        assertThat(win1).isEqualTo(Win.FOURTH);
        assertThat(win2).isEqualTo(Win.FOURTH);
    }

    @DisplayName("3개가 일치했을 경우, 보너스 일치 여부와 상관없이 5등입니다.")
    @Test
    void winFifth() {
        //given & when
        Win win1 = Win.find(3, true).get();
        Win win2 = Win.find(3, false).get();

        //then
        assertThat(win1).isEqualTo(Win.FIFTH);
        assertThat(win2).isEqualTo(Win.FIFTH);
    }

    @DisplayName("3개 미만으로 일치했을 경우, 보너스 일치 여부와 상관없이 등수가 없습니다.")
    @Test
    void winNothing() {
        //given & when
        Optional<Win> win1 = Win.find(2, true);
        Optional<Win> win2 = Win.find(1, false);
        Optional<Win> win3 = Win.find(0, true);

        //then
        assertThat(win1.isPresent()).isFalse();
        assertThat(win2.isPresent()).isFalse();
        assertThat(win3.isPresent()).isFalse();
    }
}