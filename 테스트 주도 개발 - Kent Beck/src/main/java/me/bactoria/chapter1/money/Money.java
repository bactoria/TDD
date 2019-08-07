package me.bactoria.chapter1.money;

import java.util.Objects;

/**
 * @author Bactoria
 * @since 2019-08-07 [2019.8월.07]
 */

public class Money {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money doller(int amount) {
        return new Doller(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Money money = (Money) o;
        return amount == money.amount &&
                Objects.equals(currency, money.currency);
    }

    public String currency() {
        return this.currency;
    }
}
