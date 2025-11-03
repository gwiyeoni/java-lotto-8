package lotto.common;

public class ErrorMessage {

    private static final String ERROR_MSG = "[ERROR] ";

    public static final String NOT_NUM = ERROR_MSG + "구입 금액은 숫자여야 합니다.";
    public static final String NOT_THOUSAND = ERROR_MSG + "구입 금액은 1,000원 단위여야 합니다.";
    public static final String NOT_POSITIVE_NUM = ERROR_MSG + "구입 금액은 0보다 커야 합니다.";
    public static final String NOT_LOTTO_NUMBER_COUNT = ERROR_MSG + "로또 번호는 6개여야 합니다.";
    public static final String NOT_UNIQUE_LOTTO_NUMBER = ERROR_MSG + "로또 번호는 중복될 수 없습니다.";

    public static final String NOT_WINNING_NUMBER_FORMAT = ERROR_MSG + "쉼표(,)로 구분된 6개의 숫자를 입력해야 합니다.";
    public static final String NOT_WINNING_NUMBER_NUMERIC = ERROR_MSG + "당첨 번호는 숫자여야 합니다.";
    public static final String NOT_WINNING_NUMBER_RANGE = ERROR_MSG + "로또 번호는 " +
            Constants.LOTTO_NUMBER_MIN + "부터 " + Constants.LOTTO_NUMBER_MAX + " 사이의 숫자여야 합니다.";

}
