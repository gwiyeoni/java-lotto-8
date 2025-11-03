package lotto.controller;

import lotto.Lotto;
import lotto.common.Constants;
import lotto.domain.LottoGenerator;
import lotto.util.StringParser;
import lotto.validation.PurchaseAmountValidator;
import lotto.validation.WinningNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final LottoGenerator lottoGenerator;
    private final List<Lotto> lottos;

    public LottoController() {
        this.lottoGenerator = new LottoGenerator();
        this.lottos = new ArrayList<>();
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();

        int lottoCount = purchaseAmount / Constants.LOTTO_PRICE;
        OutputView.printPurchasedLottoCount(lottoCount);

        generateLottos(lottoCount);
        OutputView.printPurchasedLottos(lottos);

        Lotto winningLotto = getWinningNumbers();
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

    private void generateLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoGenerator.generate());
        }
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                String input = InputView.readWinningNumbers();
                WinningNumbersValidator.validate(input);
                List<Integer> numbers = StringParser.parseNumbers(input);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}