package lotto;

import java.util.Collections;
import java.util.List;

public class Output {
    public static void informPurchase(List<Lotto> lottos) {
        System.out.printf("%s개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public static void informResults(List<Prize> results) {
        float profit = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize prize : Prize.values()) {
            if (prize.equals(Prize.NOTHING)) {
                continue;
            }
            System.out.printf("%s (%s원) - %d개\n",
                prize.getMatch(),
                String.format("%,d", prize.getMoney()),
                Collections.frequency(results, prize));
            profit += prize.getMoney() * Collections.frequency(results, prize);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit / 1000 * results.size() * 100);
    }
}
