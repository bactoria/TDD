package me.bactoria.chapter1.domain;

/**
 * @author Bactoria
 * @since 2019-08-09 [2019.8월.09]
 */

public interface Expression {
    Money reduce(Bank bank, String to);
    Expression plus(Expression addend);
    Expression times(int multiplier);
}
