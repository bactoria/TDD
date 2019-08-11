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
        Expression sum = new Sum(five, five);

        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");

        assertThat(reduced).isEqualTo(Money.doller(10));
    }

    @Test
    public void 통화가_다른_Money_덧셈_테스트() {
        Expression fiveBucks = Money.doller(5);
        Expression tenFrances = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Money result = bank.reduce(fiveBucks.plus(tenFrances), "USD");

        assertThat(result).isEqualTo(Money.doller(10));
    }

}
