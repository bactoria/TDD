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
        Franc fiveFranc = new Franc(5);
        Franc result = fiveFranc.times(2);
        assertThat(result).isEqualTo(new Franc(10));
    }

    @Test
    public void Franc_동등성_검사() {

        Franc money = new Franc(5);

        assertThat(money).isEqualTo(new Franc(5));
        assertThat(money).isNotEqualTo(new Franc(6));

    }
}
