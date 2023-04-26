package lotto.domain;

import lotto.utils.LottoCalculator;
import lotto.utils.LottoGenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class User {

    private BigDecimal cost;
    private List<Lotto> lottos = new ArrayList<>();
    private int[] ranks = new int[6];
    private BigDecimal prize = BigDecimal.ZERO;
    private BigDecimal profit;

    public User(BigDecimal cost) {
        this.cost = cost;
        buyLottos();
    }

    private void buyLottos() {
        for (int i = 0; i < cost.divide(BigDecimal.valueOf(1000)).longValue(); i++) {
            Lotto lotto = LottoGenerator.generate();
            lottos.add(lotto);
        }
    }

    public BigDecimal getCost() {
        return cost;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int[] getRanks() {
        return ranks;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void calculate(Lotto winning, int bonusNumber) {
        for (Lotto lotto : lottos) {
            LottoCalculator.calculate(lotto, winning, bonusNumber).ifPresent(win -> {
                ranks[win.getRank()]++;
                prize = prize.add(win.getPrize());
            });
        }
        profit = prize.multiply(new BigDecimal(100)).divide(cost, 1, RoundingMode.HALF_UP);
    }
}
