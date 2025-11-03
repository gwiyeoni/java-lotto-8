package lotto.common;

public class ErrorMessage {

    private static final String ERROR_MSG = "[ERROR] ";

    public static final String NOT_NUM = ERROR_MSG + "구입 금액은 숫자여야 합니다.";
    public static final String NOT_THOUSAND = ERROR_MSG + "구입 금액은 1,000원 단위여야 합니다.";
    public static final String NOT_POSITIVE_NUM = ERROR_MSG + "구입 금액은 0보다 커야 합니다.";
    public static final String NOT_LOTTO_NUMBER_COUNT = ERROR_MSG + "로또 번호는 6개여야 합니다.";
    public static final String NOT_UNIQUE_LOTTO_NUMBER = ERROR_MSG + "로또 번호는 중복될 수 없습니다.";

}
