package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ResolverTest {

    @DisplayName("\"1000\"이 주어질 경우, 1000으로 변환합니다.")
    @Test
    void resolveStringToInt() {
        //given
        String input = "1000";

        //when
        int cost = Resolver.resolveCost(input);

        //then
        assertThat(cost).isEqualTo(1000);
    }

    @DisplayName("\"1,2,3,4,5,6\"이 주어질 경우, 숫자가 담긴 리스트로 변환합니다.")
    @Test
    void resolveStringToIntegerList() {
        //given
        String input = "1,2,3,4,5,6";

        //when
        List<Integer> winningNumbers = Resolver.resolveWinningNumbers(input);

        //then
        assertThat(winningNumbers).isEqualTo(List.of(1,2,3,4,5,6));
    }
}