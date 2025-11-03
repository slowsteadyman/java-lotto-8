package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Lotto.ERROR_LOTTOS_ARE_6);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Lotto.ERROR_LOTTONUMBER_DUPLICATE);
    }

    @DisplayName("로또 번호가 1에서 45사이가 아니면 예외가 발생한다")
    @Test
    void 로또_번호가_1에서_45사이가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Lotto.ERROR_LOTTONUMBER_BOUNDARY);
    }

    @DisplayName("로또 번호가_숫자가_아니면_예외가_발생한다")
    @Test
    void 로또_번호가_숫자가_아니면_예외가_발생한다() {
        String[] input = {"1", "2", "3", "4", "5", "a"};
        assertThatThrownBy(() -> Validator.ValidateWinningNumbers(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Validator.ERROR_WINNINGNUMBER_IS_NUMBER);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String rawBonusNumber = "1";
        assertThatThrownBy(() -> Lotto.validateBonusNumber(lotto, rawBonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Lotto.ERROR_LOTTONUMBER_DUPLICATE);
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다")
    @Test
    void 보너스_번호가_숫자가_아니면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String rawBonusNumber = "a";
        assertThatThrownBy(() -> Lotto.validateBonusNumber(lotto, rawBonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Lotto.ERROR_BONUSNUMBER_IS_NUMBER);
    }
}
