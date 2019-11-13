package me.bactoria.TddProject.iloveyouboss;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * @author Bactoria
 * @since 2019-11-13 [2019.11월.13]
 */

public class ProfileTest {

    @Test
    public void matchesNothingWhenProfileEmpty() {
        Profile profile = new Profile();
        Question question = new BooleanQuestion(1, "Relocation package?");
        Criterion criterion = new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }
}