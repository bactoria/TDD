package me.bactoria.chapter1.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bactoria
 * @since 2019-08-11 [2019.8월.11]
 */

public class SumMultiplyTest {

    @Test
    public void Sum_곱셈_테스트() {
        Expression fiveDoller = Money.doller(5);
        Expression tenFranc = Money.franc(10);

        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Expression sum = new Sum(fiveDoller, tenFranc).times(2);
        Expression result = sum.reduce(bank, "USD");

        assertThat(result).isEqualTo(Money.doller(20));
    }
}
