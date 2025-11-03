package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String rawPurchaseAmount;
        String[] rawWinningNumbers;
        String rawBonusNumber;
        int purchaseAmount;
        List<Lotto> lottos = new ArrayList<>();
        Lotto winningNumbers;
        int bonusNumber;

        while (true) {
            rawPurchaseAmount = Input.readPurchaseAmount();
            try {
                purchaseAmount = Validator.ValidatePurchaseAmount(rawPurchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lottos = Lotto.purchaseLottos(purchaseAmount);
        Output.informPurchase(lottos);

        while (true) {
            rawWinningNumbers = Input.readWinningNumbers();
            try {
                winningNumbers = new Lotto(Validator.ValidateWinningNumbers(rawWinningNumbers));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            rawBonusNumber = Input.readBonusNumber();
            try {
                bonusNumber = Lotto.validateBonusNumber(winningNumbers, rawBonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Prize> results = Result.results(lottos, winningNumbers, bonusNumber);
        Output.informResults(results);
    }
}
