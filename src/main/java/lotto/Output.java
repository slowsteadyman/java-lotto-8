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
        float profit = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize prize : Prize.values()) {
            int prizeCount = Collections.frequency(results, prize);
            if (prize.equals(Prize.NOTHING)) {
                continue;
            }
            System.out.printf("%s (%s원) - %d개\n",
                prize.getMatch(), String.format("%,d", prize.getMoney()), prizeCount);
            profit += prize.getMoney() * prizeCount;
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", (profit / purchaseAmount) * 100);
    }
}
