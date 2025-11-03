package lotto.test;

import lotto.Lotto;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchaseAmountValidator;
import lotto.validation.WinningNumbersValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("구입 금액 검증")
    @ParameterizedTest
    @ValueSource(strings = {"1000j", "1500", "0", "-1000"})
    void 구입_금액_검증(String input) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 검증")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5",
            "1,2,3,4,5,a",
            "1,2,3,4,5,46",
            "1,2,3,4,5,5"
    })
    void 당첨_번호_검증(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 검증")
    @ParameterizedTest
    @ValueSource(strings = {"a", "0", "46"})
    void 보너스_번호_검증_숫자_범위(String input) {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> BonusNumberValidator.validate(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 검증 - 중복 예외")
    @Test
    void 보너스_번호_검증_중복() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> BonusNumberValidator.validate("6", winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}