package lotto.validation;

import lotto.Lotto;
import lotto.common.Constants;
import lotto.common.ErrorMessage;

public class BonusNumberValidator {

    public static void validate(String input, Lotto winningLotto) {
        int bonusNumber = validateAndParseNumeric(input);
        validateRange(bonusNumber);
        validateDuplicate(bonusNumber, winningLotto);
    }

    private static int validateAndParseNumeric(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BONUS_NUMBER_NUMERIC);
        }
    }

    private static void validateRange(int number) {
        if (number < Constants.LOTTO_NUMBER_MIN || number > Constants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NOT_WINNING_NUMBER_RANGE);
        }
    }

    private static void validateDuplicate(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_UNIQUE_BONUS_NUMBER);
        }
    }
}