package lotto.domain;

import lotto.constant.Winning;

public class WinningResult {

    private int cost;
    private int[] ranks;
    private int prize;

    public WinningResult(int lottoCount) {
        this.cost = lottoCount * Lotto.PRICE;
        this.ranks = new int[Winning.values().length + 1];
        this.prize = 0;
    }

    public void add(Winning winning) {
        ranks[winning.getRank()]++;
        prize += winning.getPrize();
    }

    public double getProfitRate() {
        return ((double) prize / cost) * 100;
    }

    public int getCost() {
        return cost;
    }

    public int getRank(int rank) {
        return ranks[rank];
    }

    public int getPrize() {
        return prize;
    }
}
