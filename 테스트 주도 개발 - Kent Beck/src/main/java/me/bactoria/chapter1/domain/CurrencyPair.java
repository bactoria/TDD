package me.bactoria.chapter1.domain;

import java.util.Objects;

/**
 * @author Bactoria
 * @since 2019-08-09 [2019.8월.09]
 */

public class CurrencyPair {
    private String from;
    private String to;

    public CurrencyPair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyPair that = (CurrencyPair) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
