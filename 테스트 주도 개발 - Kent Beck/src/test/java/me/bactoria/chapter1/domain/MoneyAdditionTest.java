package me.bactoria.chapter1.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bactoria
 * @since 2019-08-08 [2019.8월.08]
 */

public class MoneyAdditionTest {

    @Test
    public void 덧셈_테스트() {
        Money five = Money.doller(5);
        Expression sum = five.plus(five);

        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");

        assertThat(reduced).isEqualTo(Money.doller(10));
    }

}
