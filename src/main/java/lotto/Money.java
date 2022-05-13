package lotto;

import java.util.Objects;

public class Money {
    private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수가 입력되어 유효하지 않습니다.";
    public static final int ZERO_NUM = 0;
    private final int money;

    private Money(int money) {
        validMoney(money);
        this.money = money;
    }

    public static Money from(int money) {
        return new Money(money);
    }

    private void validMoney(int money) {
        if(money < ZERO_NUM) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
