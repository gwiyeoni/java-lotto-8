package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> statistics;

    public LottoResult() {
        this.statistics = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : LottoRank.values()) {
            statistics.put(rank, 0);
        }
    }

    public void add(LottoRank rank) {
        statistics.put(rank, statistics.get(rank) + 1);
    }

    public long calculateTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : statistics.entrySet()) {
            totalPrize += (long) entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return totalPrize;
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        if (purchaseAmount == 0) {
            return 0.0;
        }

        return ((double) totalPrize / purchaseAmount) * 100.0;
    }

    public Map<LottoRank, Integer> getStatistics() {
        return statistics;
    }
}