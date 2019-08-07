package me.bactoria.chapter1.money;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bactoria
 * @since 2019-08-07 [2019.8월.07]
 */

public class FrancTest {

    @Test
    public void Franc은_곱셈이_가능하다() {
        Money fiveFranc = Money.franc(5);
        Money result = fiveFranc.times(2);

        assertThat(result).isEqualTo(Money.franc(10));
    }

    @Test
    public void Franc_동등성_검사() {
        Money money = Money.franc(5);

        assertThat(money).isEqualTo(Money.franc(5));
        assertThat(money).isNotEqualTo(Money.franc(6));
    }
}
