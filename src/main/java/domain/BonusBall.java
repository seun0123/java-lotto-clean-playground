package domain;

public class BonusBall {
    private final LottoNumber bonusBall;

    public BonusBall(LottoNumber bonusBall) {
        this.bonusBall = bonusBall;
    }

    public static BonusBall of(int number) {
        return new BonusBall(LottoNumber.of(number));
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
