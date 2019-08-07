package me.bactoria.chapter1.money;

/**
 * @author Bactoria
 * @since 2019-08-07 [2019.8월.07]
 */

public class Franc extends Money{

    public Franc(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    Money times(int multiplier) {
        return Money.franc(this.amount * multiplier);
    }
}
