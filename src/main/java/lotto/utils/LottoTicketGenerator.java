package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {

    /**
     * 여러개 로또가 있는 로또 티켓을 생성하는 기능
     * @param count
     * @return LottoTicket
     */
    public static LottoTicket generate(int count) {
        List<Lotto> lottos = new ArrayList<>();
        while (count-- > 0) {
            lottos.add(LottoGenerator.generate());
        }
        return new LottoTicket(lottos);
    }
}
