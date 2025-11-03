package lotto.test;

import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoDomainTest {

    @DisplayName("LottoRank 등수 판별 테스트")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "4, true, FOURTH",
            "3, false, FIFTH",
            "2, true, MISS",
            "0, false, MISS"
    })
    void 등수_판별(int matchCount, boolean bonusMatch, LottoRank expectedRank) {
        assertThat(LottoRank.valueOf(matchCount, bonusMatch)).isEqualTo(expectedRank);
    }

    @DisplayName("LottoResult 수익률 계산 테스트")
    @Test
    void 수익률_계산() {
        LottoResult result = new LottoResult();
        result.add(LottoRank.FIFTH);
        int purchaseAmount = 8000;

        double profitRate = result.calculateProfitRate(purchaseAmount);

        assertThat(profitRate).isEqualTo(62.5);
    }

    @DisplayName("LottoResult 총 당첨금 계산 테스트")
    @Test
    void 총_당첨금_계산() {
        LottoResult result = new LottoResult();
        result.add(LottoRank.FIFTH);
        result.add(LottoRank.FIFTH);
        result.add(LottoRank.FOURTH);

        long totalPrize = result.calculateTotalPrize();

        assertThat(totalPrize).isEqualTo(60_000L);
    }
}