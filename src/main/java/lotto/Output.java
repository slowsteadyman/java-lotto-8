package lotto;

import java.util.List;

public class Output {
    public static void informPurchase(List<Lotto> lottos) {
        System.out.printf("%s개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }
}
