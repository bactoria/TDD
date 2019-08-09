package me.bactoria.chapter1.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Bactoria
 * @since 2019-08-07 [2019.8월.07]
 */

public class DollerTest {

    @Test
    public void Doller는_곱셈이_가능하다() {
        Money fiveDoller = Money.doller(5);

        Money result = fiveDoller.times(2);
        assertThat(result).isEqualTo(Money.doller(10));
    }

    @Test
    public void Doller는_재사용이_가능하다() {
        Money fiveDoller = Money.doller(5);

        Money result = fiveDoller.times(2);
        assertThat(result).isEqualTo(Money.doller(10));

        result = fiveDoller.times(3);
        assertThat(result).isEqualTo(Money.doller(15));
    }

    @Test
    public void Doller의_값이_같으면_동치이다() {
        Money doller1 = Money.doller(5);
        Money doller2 = Money.doller(5);

        assertThat(doller1).isEqualTo(doller2);
    }
}
