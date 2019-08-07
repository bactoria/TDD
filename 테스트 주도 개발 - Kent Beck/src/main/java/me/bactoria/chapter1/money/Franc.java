package me.bactoria.chapter1.money;

import java.util.Objects;

/**
 * @author Bactoria
 * @since 2019-08-07 [2019.8월.07]
 */

public class Franc {

    private int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int multiplier) {
        return new Franc(this.amount * multiplier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Franc franc = (Franc) o;
        return amount == franc.amount;
    }
}
