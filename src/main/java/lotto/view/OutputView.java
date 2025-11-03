package lotto.view;

import lotto.Lotto;
import lotto.common.Message;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printPurchasedLottoCount(int count) {
        System.out.printf(Message.PROMPT_PURCHASED_LOTTO_COUNT, count);
        System.out.println();
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            String lottoNumbers = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + lottoNumbers + "]");
        }
    }
}