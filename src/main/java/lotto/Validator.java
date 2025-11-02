package lotto;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final String ERROR_PURCHASEAMOUNT_IS_NUMBER = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String ERROR_PURCHASEAMOUNT_DIVIDED_1000 =
        "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.";
    private static final String ERROR_WINNINGNUMBER_IS_NUMBER = "[ERROR] 로또 번호는 ,로 구분된 숫자여야 합니다.";

    public static int ValidatePurchaseAmount(String rawPurchaseAmount) {
        int purchaseAmount = 0;

        try {
            purchaseAmount = Integer.parseInt(rawPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PURCHASEAMOUNT_IS_NUMBER);
        }

        if ((purchaseAmount % 1000) != 0) {
            throw new IllegalArgumentException(ERROR_PURCHASEAMOUNT_DIVIDED_1000);
        }

        return purchaseAmount / 1000;
    }

    public static List<Integer> ValidateWinningNumbers(String[] rawWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        int winningNumber = 0;

        for (String rawWinningNumber : rawWinningNumbers) {
            try {
                winningNumber = Integer.parseInt(rawWinningNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_WINNINGNUMBER_IS_NUMBER);
            }

            winningNumbers.add(winningNumber);
        }

        return winningNumbers;
    }
}
