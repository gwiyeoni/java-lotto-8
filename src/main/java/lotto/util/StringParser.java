package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.Constants;

public class StringParser {

    public static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(Constants.DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}