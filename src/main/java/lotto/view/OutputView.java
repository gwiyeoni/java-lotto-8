package lotto.view;

import lotto.Lotto;
import lotto.common.Message;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.Map;
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

    public static void printWinningStatistics(LottoResult result) {
        System.out.println(Message.PROMPT_WINNING_STATISTICS_HEADER);
        System.out.println(Message.PROMPT_SEPARATOR_LINE);

        Map<LottoRank, Integer> statistics = result.getStatistics();

        System.out.println(formatRank(LottoRank.FIFTH, statistics.get(LottoRank.FIFTH)));
        System.out.println(formatRank(LottoRank.FOURTH, statistics.get(LottoRank.FOURTH)));
        System.out.println(formatRank(LottoRank.THIRD, statistics.get(LottoRank.THIRD)));
        System.out.println(formatRank(LottoRank.SECOND, statistics.get(LottoRank.SECOND)));
        System.out.println(formatRank(LottoRank.FIRST, statistics.get(LottoRank.FIRST)));
    }

    private static String formatRank(LottoRank rank, int count) {

        if (rank == LottoRank.SECOND) {
            return String.format(
                    Message.PROMPT_STATISTICS_BONUS_FORMAT,
                    rank.getMatchCount(),
                    rank.getPrizeMoney(),
                    count
            );
        }

        return String.format(
                Message.PROMPT_STATISTICS_FORMAT,
                rank.getMatchCount(),
                rank.getPrizeMoney(),
                count
        );
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(Message.PROMPT_PROFIT_RATE_FORMAT, profitRate);
        System.out.println();
    }
}