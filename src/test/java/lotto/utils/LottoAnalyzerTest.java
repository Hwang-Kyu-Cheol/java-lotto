package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoAnalyzerTest {

    @Test
    void test() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        LottoTicket lottoTicket = new LottoTicket(List.of(lotto1, lotto2));

        WinningLotto winningLotto = new WinningLotto(List.of(3, 4, 5, 6, 7, 8), 11);

        WinningResult winningResult = LottoAnalyzer.analyze(winningLotto, lottoTicket);
        System.out.println(winningResult.getCost());
        System.out.println(winningResult.getPrize());
        System.out.println(winningResult.getProfitRate());
    }

    @Test
    void test1() {
        LottoTicket lottoTicket = LottoTicketGenerator.generate(1000);

        Output.showLottoTicket(lottoTicket);

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        WinningResult winningResult = LottoAnalyzer.analyze(winningLotto, lottoTicket);

        Output.showLottoAnalysis(winningResult);
    }
}