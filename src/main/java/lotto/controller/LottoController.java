package lotto.controller;

import lotto.common.Constants;
import lotto.validation.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        int purchaseAmount = getPurchaseAmount();

        int lottoCount = purchaseAmount / Constants.LOTTO_PRICE;
        OutputView.printPurchasedLottoCount(lottoCount);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.readPurchaseAmount();
                PurchaseAmountValidator.validate(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}