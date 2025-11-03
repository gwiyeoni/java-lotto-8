package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.common.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_NUMBER_MIN,
                Constants.LOTTO_NUMBER_MAX,
                Constants.LOTTO_NUMBER_COUNT
        );

        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return new Lotto(sortedNumbers);
    }
}
