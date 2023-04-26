package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}