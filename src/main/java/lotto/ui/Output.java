package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningResult;

import java.util.Collections;
import java.util.List;

public class Output {

    /**
     * 발행한 로또 티켓을 화면에 출력하는 기능
     * @param lottoTicket
     */
    public static void showLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTicket.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
        System.out.println();
    }

    /**
     * 로또 결과 통계를 출력하는 기능
     * @param winningResult
     */
    public static void showLottoAnalysis(WinningResult winningResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningResult.getRank(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningResult.getRank(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningResult.getRank(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResult.getRank(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningResult.getRank(1));
        System.out.println("총 수익률은 " + String.format("%.1f", winningResult.getProfitRate()) + "%입니다.");
    }

    public static void enterLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void enterWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void enterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
