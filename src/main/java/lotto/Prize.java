package lotto;

public enum Prize {
    NOTHING("3개 미만 일치", 0),
    THREE("3개 일치", 5000),
    FOUR("4개 일치", 50000),
    FIVE("5개 일치", 1500000),
    FIVENBONUS("5개 일치, 보너스 볼 일치", 30000000),
    SIX("6개 일치", 2000000000);

    private final String match;
    private final int money;

    Prize(String match, int money) {
        this.match = match;
        this.money = money;
    }

    public String getMatch() {
        return this.match;
    }

    public int getMoney() {
        return this.money;
    }
}
