package lotto;

import lotto.controller.LottoController;
import lotto.ui.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoController.run();
        } catch (IllegalArgumentException e) {
            Output.showErrorMessage(e);
        }
    }
}
