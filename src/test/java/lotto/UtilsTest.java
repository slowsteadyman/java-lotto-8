package lotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {
    @DisplayName("구입 개수만큼 로또 구매")
    @Test
    void 구입_개수만큼_로또_구매() {
        int purchaseAmount = 3000;
        List<Lotto> lottos = Utils.purchaseLottos(purchaseAmount);
        assertThat(lottos.size()).isEqualTo(3);
    }

    @DisplayName("중복되지 않게 로또 구매")
    @Test
    void 중복되지_않게_로또_구매() {
        int purchaseAmount = 10000;
        List<Lotto> lottos = Utils.purchaseLottos(purchaseAmount);
        for (int i = 0; i < lottos.size(); i++) {
            for (int j = i + 1; j < lottos.size(); j++) {
                assertThat(Lotto.howManyMatchLotto(lottos.get(i), lottos.get(j))).isNotEqualTo(6);
            }
        }
    }

    @DisplayName("당첨 로또 확인 5개")
    @Test
    void 당첨_로또_확인_5개 () {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,7));
        int bonusNumber = 45;
        assertThat(Utils.lottoResult(lotto, winningLotto, bonusNumber)).isEqualTo(Prize.FIVE);
    }

    @DisplayName("당첨 로또 확인 5개와 보너스볼")
    @Test
    void 당첨_로또_확인_5개와_보너스볼 () {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,7));
        int bonusNumber = 6;
        assertThat(Utils.lottoResult(lotto, winningLotto, bonusNumber)).isEqualTo(Prize.FIVENBONUS);
    }

    @DisplayName("당첨 로또 확인 6개")
    @Test
    void 당첨_로또_확인_6개 () {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        assertThat(Utils.lottoResult(lotto, winningLotto, bonusNumber)).isEqualTo(Prize.SIX);
    }
}
