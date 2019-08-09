package me.bactoria.chapter1.domain;

/**
 * @author Bactoria
 * @since 2019-08-09 [2019.8월.09]
 */

public class Bank {
    Money reduce (Expression source, String to) {
        if( source instanceof Money) {
            return (Money) source;
        }

        Sum sum = (Sum) source;
        return sum.reduce(to);
    }
}
