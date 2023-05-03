package lotto.constant;

public class ErrorMessage {

    private static final String ERROR = "[ERROR]";

    public static final String INVALID_LOTTO_PRICE = ERROR + " " + "유효하지 않은 로또 구입 금액입니다.";
    public static final String INVALID_LOTTO_NUMBERS = ERROR + " " + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INVALID_BONUS_NUMBER = ERROR + " " + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATED_NUMBERS = ERROR + " " + "번호는 중복되면 안됩니다.";
}
