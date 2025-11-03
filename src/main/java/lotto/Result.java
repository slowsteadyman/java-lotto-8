package lotto;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public static List<Prize> results(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        List<Prize> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Prize lottoResult = lottoResult(lotto, winningNumbers, bonusNumber);
            results.add(lottoResult);
        }
        return results;
    }

    public static Prize lottoResult(Lotto lotto, Lotto winningNumbers, int bonusNumber) {
        switch (Lotto.howManyMatchLotto(lotto, winningNumbers)) {
            case 3:
                return Prize.THREE;
            case 4:
                return Prize.FOUR;
            case 5:
                if (lotto.contains(bonusNumber)) {
                    return Prize.FIVENBONUS;
                }
                return Prize.FIVE;
            case 6:
                return Prize.SIX;
            default:
                return Prize.NOTHING;
        }
    }
}