package me.bactoria.chapter1.money;

import java.util.Objects;

/**
 * @author Bactoria
 * @since 2019-08-07 [2019.8월.07]
 */

public class Doller {

    int amount;

    public Doller(int amount) {
        this.amount = amount;
    }

    Doller times(int multiplier) {
        return new Doller(this.amount * multiplier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doller doller = (Doller) o;
        return amount == doller.amount;
    }
}
