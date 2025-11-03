package lotto.controller;

import lotto.Lotto;
import lotto.common.Constants;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.util.StringParser;
import lotto.validation.BonusNumberValidator;
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
        int bonusNumber = getBonusNumber(winningLotto);

        LottoResult result = calculateResults(winningLotto, bonusNumber);
        double profitRate = result.calculateProfitRate(purchaseAmount);

        OutputView.printWinningStatistics(result);
        OutputView.printProfitRate(profitRate);
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

    private int getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String input = InputView.readBonusNumber();
                BonusNumberValidator.validate(input, winningLotto); // 1. 검증 (winningLotto 전달)
                return Integer.parseInt(input.trim()); // 2. 변환
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private LottoResult calculateResults(Lotto winningLotto, int bonusNumber) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {

            int matchCount = lotto.countMatchingNumbers(winningLotto);
            boolean bonusMatch = lotto.contains(bonusNumber);

            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

            result.add(rank);
        }
        return result;
    }
}