package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int MIN_LOTTO = 1;
    public static final int MAX_LOTTO = 45;
    private static final String ERROR_LOTTOS_ARE_6 = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_LOTTONUMBER_BOUNDARY =
        "[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.";
    private static final String ERROR_LOTTONUMBER_DUPLICATE =
        "[ERROR] 로또 번호는 중복이 없어야 합니다.";
    private static final String ERROR_BONUSNUMBER_IS_NUMBER =
        "[ERROR] 보너스 번호는 숫자여야 합니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> removeDuplicates = Utils.removeDuplicates(numbers);

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTOS_ARE_6);
        }

        if (removeDuplicates.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTONUMBER_DUPLICATE);
        }

        for (Integer lottoNumber : numbers) {
            validateBoundary(lottoNumber);
        }
    }

    public void printLotto() {
        List<Integer> temp = new ArrayList<>(this.numbers);
        Collections.sort(temp);
        List<String> lottoNumbers = this.numbers.stream().map(String::valueOf).toList();
        System.out.printf("[%s]\n", String.join(", ", lottoNumbers));
    }

    public Boolean isAlreadyPurchased(List<Lotto> lottos) {
        for  (Lotto lotto : lottos) {
            if (howManyMatchLotto(this, lotto) == 6) {
                return true;
            }
        }
        return false;
    }

    public Boolean contains(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public static int validateBonusNumber(Lotto lotto, String rawBonusNumber) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(rawBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_BONUSNUMBER_IS_NUMBER);
        }
        for (Integer lottoNumber : lotto.numbers) {
            validateBoundary(lottoNumber);
            if (bonusNumber == lottoNumber) {
                throw new IllegalArgumentException(ERROR_LOTTONUMBER_DUPLICATE);
            }
        }
        return bonusNumber;
    }

    public static int howManyMatchLotto(Lotto lottoA, Lotto lottoB) {
        int match = 0;
        for (Integer lottoNumber : lottoA.numbers)  {
            if (lottoB.numbers.contains(lottoNumber)) {
                match++;
            }
        }
        return match;
    }

    public static void validateBoundary(Integer lottoNumber) {
        if (lottoNumber < MIN_LOTTO || lottoNumber > MAX_LOTTO) {
            throw new IllegalArgumentException(ERROR_LOTTONUMBER_BOUNDARY);
        }
    }
}
