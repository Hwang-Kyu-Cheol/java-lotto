package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public int size() {
        return lottos.size();
    }

}
