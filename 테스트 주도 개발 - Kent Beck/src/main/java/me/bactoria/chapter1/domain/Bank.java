package me.bactoria.chapter1.domain;

import java.util.Hashtable;

/**
 * @author Bactoria
 * @since 2019-08-09 [2019.8월.09]
 */

public class Bank {

    private Hashtable<CurrencyPair, Integer> rates = new Hashtable<>();

    Money reduce (Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new CurrencyPair(from, to), rate);
    }

    public int rate(String from, String to) {
        if(from.equals(to)) return 1;
        return rates.get(new CurrencyPair(from, to));
    }
}
