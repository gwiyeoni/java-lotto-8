package lotto.validation;

import lotto.common.Constants;
import lotto.common.ErrorMessage;

public class PurchaseAmountValidator {

    public static void validate(String input) {
        validateIsNumeric(input);
        int amount = Integer.parseInt(input);
        validateIsThousandUnit(amount);
        validateIsPositive(amount);
    }

    private static void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUM);
        }
    }

    private static void validateIsThousandUnit(int amount) {
        if (amount % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND);
        }
    }

    private static void validateIsPositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUM);
        }
    }
}