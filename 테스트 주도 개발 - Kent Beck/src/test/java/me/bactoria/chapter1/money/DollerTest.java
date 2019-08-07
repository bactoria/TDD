package me.bactoria.chapter1.money;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bactoria
 * @since 2019-08-07 [2019.8월.07]
 */

public class DollerTest {

    @Test
    public void Doller는_곱셈이_가능하다() {
        Doller fiveDoller = new Doller(5);
        fiveDoller.times(2);
        assertThat(fiveDoller.amount).isEqualTo(10);
    }

    @Test
    public void Doller는_재사용이_가능하다() {
        Doller fiveDoller = new Doller(5);

        Doller result = fiveDoller.times(2);
        assertThat(result.amount).isEqualTo(10);

        result = fiveDoller.times(3);
        assertThat(result.amount).isEqualTo(15);
    }
}
