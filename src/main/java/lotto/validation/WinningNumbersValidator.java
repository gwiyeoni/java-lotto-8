package lotto.validation;

import lotto.common.Constants;
import lotto.common.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbersValidator {

    public static void validate(String input) {
        String[] parts = input.split(Constants.DELIMITER);

        validateCount(parts);
        List<Integer> numbers = validateAndParseNumbers(parts);
        validateRange(numbers);
        validateDuplicates(numbers);
    }

    private static void validateCount(String[] parts) {
        if (parts.length != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_WINNING_NUMBER_FORMAT);
        }
    }

    private static List<Integer> validateAndParseNumbers(String[] parts) {
        try {
            return Arrays.stream(parts)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_WINNING_NUMBER_NUMERIC);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Constants.LOTTO_NUMBER_MIN || number > Constants.LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(ErrorMessage.NOT_WINNING_NUMBER_RANGE);
            }
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_UNIQUE_LOTTO_NUMBER);
        }
    }
}