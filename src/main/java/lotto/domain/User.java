package lotto.domain;

import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int cost;
    private List<Lotto> lottos = new ArrayList<>();
    private int[] rank = new int[6];
    private int prize;
    private double profit;

    public User(int cost) {
        this.cost = cost;
        buyLottos(cost);
        for (int i = 0; i < cost / 1000; i++) {
            Lotto lotto = LottoGenerator.generate();
            this.lottos.add(lotto);
        }
    }

    public void buyLottos(int cost) {
        for (int i = 0; i < cost / 1000; i++) {
            Lotto lotto = LottoGenerator.generate();
            lottos.add(lotto);
        }
    }
}
