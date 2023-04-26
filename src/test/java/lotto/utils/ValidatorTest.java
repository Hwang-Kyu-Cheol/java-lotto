package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @DisplayName("금액이 정수일 경우, IllegalArgumentException이 발생하지 않습니다.")
    @Test
    void costIsNumber() {
        //given
        String input = "1000";

        //when & then
        assertDoesNotThrow(() -> Validator.validateCost(input));
    }

    @DisplayName("금액이 정수가 아닐 경우, IllegalArgumentException이 발생합니다.")
    @Test
    void costIsNotNumber() {
        //given
        String input = "1000j";

        //when & then
        assertThatThrownBy(() -> Validator.validateCost(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}