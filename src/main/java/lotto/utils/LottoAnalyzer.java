package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;

public class LottoAnalyzer {

    public static WinningResult analyze(WinningLotto winningLotto, LottoTicket lottoTicket) {
        WinningResult winningResult = new WinningResult(lottoTicket.size());
        for (Lotto lotto : lottoTicket.getLottos()) {
            LottoMatcher.findWinning(winningLotto, lotto)
                    .ifPresent(winning -> winningResult.add(winning));
        }
        return winningResult;
    }
}
