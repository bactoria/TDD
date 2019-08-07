package me.bactoria.chapter1.money;

/**
 * @author Bactoria
 * @since 2019-08-07 [2019.8월.07]
 */

public class Doller extends Money{

    public Doller(int amount) {
        this.amount = amount;
    }

    @Override
    Money times(int multiplier) {
        return new Doller(this.amount * multiplier);
    }
}
