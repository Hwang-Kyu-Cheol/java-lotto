package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘을 경우, 예외가 발생합니다.")
    @Test
    void createWinningLottoByOverSize() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        int bonusNumber = 8;

        //when & then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복될 경우, 예외가 발생합니다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        //when & then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 로또 번호 범위 이외의 숫자가 있을 경우, 예외가 발생합니다.")
    @Test
    void createWinningLottoByNotInRangeNumber() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);
        int bonusNumber = 6;

        //when & then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}