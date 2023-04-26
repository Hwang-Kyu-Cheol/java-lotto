package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class Output {

    /**
     * 발행한 로또 티켓을 화면에 출력하는 기능
     * @param lottoTicket
     */
    public static void showLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTicket.getLottos()) {
            System.out.println(lotto);
        }
    }
}
