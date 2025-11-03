package lotto.view;

import lotto.common.Message;

public class OutputView {

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printPurchasedLottoCount(int count) {
        System.out.printf(Message.PROMPT_PURCHASED_LOTTO_COUNT, count);
        System.out.println();
    }
}