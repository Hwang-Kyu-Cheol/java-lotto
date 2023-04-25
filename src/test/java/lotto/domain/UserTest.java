package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void calculate() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6))));
        Lotto winning = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,8,9,10)));
        int bonusNumber = 7;

        User user = new User(new BigDecimal(1000));
        user.setLottos(lottos);

        //when
        user.calculate(winning, bonusNumber);

        //then
        assertThat(user.getPrize()).isEqualTo(BigDecimal.valueOf(5000));
        int[] ranks = {0, 0, 0, 0, 0, 1};
        for (int i = 0; i < ranks.length; i++) {
            assertThat(user.getRanks()[i]).isEqualTo(ranks[i]);
        }
        assertThat(user.getProfit()).isEqualTo(BigDecimal.valueOf(500.0));
    }
}