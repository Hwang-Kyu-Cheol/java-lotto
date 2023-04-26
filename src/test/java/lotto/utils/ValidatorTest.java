package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @DisplayName("금액이 정수, 양수, 로또 가격으로 나누어 떨어질 경우, IllegalArgumentException이 발생하지 않습니다.")
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

    @DisplayName("금액이 음수일 경우, IllegalArgumentException이 발생합니다.")
    @Test
    void costIsNegative() {
        //given
        String input = "-1000";

        //when & then
        assertThatThrownBy(() -> Validator.validateCost(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 로또 가격으로 나누어 떨어지지 않을 경우, IllegalArgumentException이 발생합니다.")
    @Test
    void costIsNotDividedByLottoPrice() {
        //given
        String input = "1500";

        //when & then
        assertThatThrownBy(() -> Validator.validateCost(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 로또 숫자 갯수와 일치하고, 숫자, 1~45일 경우, 예외가 발생하지 않습니다.")
    @Test
    void winningNumberIsOk() {
        //given
        String input = "1,2,3,4,5,6";

        //when & then
        assertDoesNotThrow(() -> Validator.validateWinningNumbers(input));
    }

    @DisplayName("당첨번호가 로또 숫자 갯수와 일치하지 않을 경우, IllegalArgumentException을 발생합니다.")
    @Test
    void winningNumberSizeIsNotEqualLottoSize() {
        //given
        String input1 = "1,2,3,4,5";
        String input2 = "1,2,3,4,5,6,7";

        //when & then
        assertThatThrownBy(() -> Validator.validateWinningNumbers(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateWinningNumbers(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}