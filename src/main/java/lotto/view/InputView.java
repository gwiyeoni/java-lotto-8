package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Message;

public class InputView {

    public static String readPurchaseAmount() {
        System.out.println(Message.PROMPT_PURCHASE_AMOUNT);
        return Console.readLine();
    }
}
