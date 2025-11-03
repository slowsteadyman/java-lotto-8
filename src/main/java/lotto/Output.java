package lotto;

import java.util.Collections;
import java.util.List;

public class Output {
    public static void printPurchase(List<Lotto> lottos) {
        System.out.printf("%s개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public static void printResults(List<Prize> results, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize prize : Prize.values()) {
            if (prize.equals(Prize.NOTHING)) {
                continue;
            }
            int prizeCount = Collections.frequency(results, prize);
            System.out.printf("%s (%s원) - %d개\n",
                prize.getMatch(), String.format("%,d", prize.getMoney()), prizeCount);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", Utils.profit(results) * 100);
    }
}
