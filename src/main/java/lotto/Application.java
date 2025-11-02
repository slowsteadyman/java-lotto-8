package lotto;

public class Application {
    public static void main(String[] args) {
        String rawPurchaseAmount;
        String[] rawWinningNumbers;
        String rawBonusNumber;
        int purchaseAmount;
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

    }
}
