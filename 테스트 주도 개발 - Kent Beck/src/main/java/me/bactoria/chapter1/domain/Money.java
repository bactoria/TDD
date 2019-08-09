package me.bactoria.chapter1.domain;

import java.util.Objects;

/**
 * @author Bactoria
 * @since 2019-08-07 [2019.8월.07]
 */

public class Money implements Expression {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money doller(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    Expression plus(Money money) {
        if(this.currency != money.currency) {
            throw new RuntimeException();
        }
        return new Money(this.amount + money.amount, this.currency);
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
