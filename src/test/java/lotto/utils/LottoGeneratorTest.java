package lotto.utils;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @DisplayName("LottoGenerator는 6개의 숫자를 골라서 로또를 생성합니다.")
    @Test
    void generateSixNumber() {
        //given & when
        Lotto lotto = LottoGenerator.generate();

        //then
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("LottoGenerator는 숫자를 정렬해서 로또를 생성합니다.")
    @Test
    void generateSortedNumber() {
        //given & when
        Lotto lotto = LottoGenerator.generate();

        //then
        assertThat(lotto.getNumbers()).isSorted();
    }
}