package me.bactoria.chapter1.money;

/**
 * @author Bactoria
 * @since 2019-08-07 [2019.8월.07]
 */

public class Money {

    protected int amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

}
