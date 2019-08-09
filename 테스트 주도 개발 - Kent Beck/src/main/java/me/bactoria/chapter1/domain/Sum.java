package me.bactoria.chapter1.domain;

/**
 * @author Bactoria
 * @since 2019-08-09 [2019.8월.09]
 */

public class Sum implements Expression {
    private Money augend;
    private Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }
}