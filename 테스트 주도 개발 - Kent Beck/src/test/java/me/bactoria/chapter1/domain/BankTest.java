package me.bactoria.chapter1.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bactoria
 * @since 2019-08-09 [2019.8월.09]
 */

public class BankTest {

    @Test
    public void  reduce_Money_테스트() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.doller(1), "USD");

        assertThat(result).isEqualTo(Money.doller(1));
    }

    @Test
    public void 다른_통화끼리도_reduce_할수있다() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Money result = bank.reduce(Money.franc(2), "USD");

        assertThat(Money.doller(1)).isEqualTo(result);
    }
}
