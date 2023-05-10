package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.ui.Input;
import lotto.ui.Output;
import lotto.utils.LottoAnalyzer;
import lotto.utils.LottoMatcher;
import lotto.utils.LottoTicketGenerator;

import java.util.List;

public class LottoController {

    public static void run() {
        LottoTicket lottoTicket = buyLottoTicket();

        WinningLotto winningLotto = generateWinningLotto();

        Output.showLottoAnalysis(LottoAnalyzer.analyze(winningLotto, lottoTicket));
    }

    private static LottoTicket buyLottoTicket() {
        Output.enterLottoPrice();
        int cost = Input.getCost();
        LottoTicket lottoTicket = LottoTicketGenerator.generate(cost);
        Output.showLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private static WinningLotto generateWinningLotto() {
        Output.enterWinningNumbers();
        List<Integer> winningNumbers = Input.getWinningNumbers();
        Output.enterBonusNumber();
        int bonusNumber = Input.getBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
