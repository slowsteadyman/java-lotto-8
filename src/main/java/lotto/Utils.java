package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Utils {
    public static HashSet<Integer> removeDuplicates(List<Integer> numbers) {
        HashSet<Integer> removeDuplicates = new HashSet<>();
        for (Integer number : numbers) {
            removeDuplicates.add(number);
        }
        return removeDuplicates;
    }

    public static List<Lotto> purchaseLottos(int purchaseAmount) {
        int purchaseCount = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        while (purchaseCount > 0) {
            Lotto newLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            if (!newLotto.isAlreadyPurchased(lottos)) {
                lottos.add(newLotto);
                purchaseCount--;
            }
        }

        return lottos;
    }

    public static List<Prize> lottoResults(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        List<Prize> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Prize lottoResult = lottoResult(lotto, winningLotto, bonusNumber);
            results.add(lottoResult);
        }
        return results;
    }

    public static Prize lottoResult(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        switch (Lotto.howManyMatchLotto(lotto, winningLotto)) {
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