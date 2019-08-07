package me.bactoria.chapter1.money;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bactoria
 * @since 2019-08-08 [2019.8월.08]
 */

public class MoneyTest {

    @Test
    public void Doller와_Franc_동치_비교() {
        Money fiveDoller = Money.doller(5);
        Money fiveFranc = Money.franc(5);

        assertThat(fiveDoller).isNotEqualTo(fiveFranc);
    }

    @Test
    public void currency_테스트() {
        Money doller = Money.doller(1);
        Money franc = Money.franc(1);

        assertThat(doller.currency()).isEqualTo("USD");
        assertThat(franc.currency()).isEqualTo("CHF");
    }

    @Test
    public void doller와_money의_통화와_값이_같다면_동치이다() {
        Money five = Money.doller(5);
        Money tenDoller= Money.doller(10);

        assertThat(five.times(2)).isEqualTo(tenDoller);
    }
}
