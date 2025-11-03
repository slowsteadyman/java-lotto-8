package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다")
    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        String rawPurchaseAmount = "a";
        assertThatThrownBy(() -> Validator.ValidatePurchaseAmount(rawPurchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Validator.ERROR_PURCHASEAMOUNT_IS_NUMBER);
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다")
    @Test
    void 구입_금액이_1000으로_나누어_떨어지지_않으면_예외가_발생한다() {
        String rawPurchaseAmount = "500";
        assertThatThrownBy(() -> Validator.ValidatePurchaseAmount(rawPurchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Validator.ERROR_PURCHASEAMOUNT_DIVIDED_1000);
    }
}
