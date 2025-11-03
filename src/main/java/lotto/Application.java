package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String rawPurchaseAmount;
        String[] rawWinningNumbers;
        String rawBonusNumber;

        int purchaseAmount;
        List<Lotto> lottos;
        Lotto winningLotto;
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

        lottos = Utils.purchaseLottos(purchaseAmount);
        Output.printPurchase(lottos);

        while (true) {
            rawWinningNumbers = Input.readWinningNumbers();
            try {
                List<Integer> winningNumbers = Validator.ValidateWinningNumbers(rawWinningNumbers);
                winningLotto = new Lotto(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            rawBonusNumber = Input.readBonusNumber();
            try {
                bonusNumber = Lotto.validateBonusNumber(winningLotto, rawBonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Prize> lottoResults = Utils.lottoResults(lottos, winningLotto, bonusNumber);
        Output.printResults(lottoResults, purchaseAmount);
    }
}
