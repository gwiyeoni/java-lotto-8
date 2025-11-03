package lotto.common;

public class ErrorMessage {

    private static final String ERROR_MSG = "[ERROR] ";

    public static final String NOT_NUM = ERROR_MSG + "구입 금액은 숫자여야 합니다.";
    public static final String NOT_THOUSAND = ERROR_MSG + "구입 금액은 1,000원 단위여야 합니다.";
    public static final String NOT_POSITIVE_NUM = ERROR_MSG + "구입 금액은 0보다 커야 합니다.";

}
