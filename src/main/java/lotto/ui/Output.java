package lotto.ui;

import lotto.constant.Winning;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningResult;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Output {

    private static DecimalFormat df = new DecimalFormat("###,###.#");

    /**
     * 발행한 로또 티켓을 화면에 출력하는 기능
     * @param lottoTicket
     */
    public static void showLottoTicket(LottoTicket lottoTicket) {
        System.out.println();
        System.out.println(lottoTicket.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTicket.getLottos()) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    /**
     * 로또 결과 통계를 출력하는 기능
     * @param winningResult
     */
    public static void showLottoAnalysis(WinningResult winningResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        Winning[] winnings = Winning.values();
        Arrays.sort(winnings, (w1, w2) -> w1.getPrize() - w2.getPrize());
        for (Winning winning : winnings) {
            StringBuilder sb = new StringBuilder();
            sb.append(winning.getEqualWinningNumbersCount() + "개 일치");
            if (winning.isMustEqualBonusNumber()) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (" + df.format(winning.getPrize()) + "원) - ");
            sb.append(winningResult.getRank(winning.getRank()) + "개");
            System.out.println(sb);
        }
        System.out.println("총 수익률은 " + df.format(winningResult.getProfitRate()) + "%입니다.");
    }

    public static void enterLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void enterWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void enterBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void showErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
