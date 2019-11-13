package me.bactoria.TddProject.iloveyouboss;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Bactoria
 * @since 2019-11-13 [2019.11월.13]
 */

public class ProfileTest {

    private Profile profile;
    private BooleanQuestion questionIsThereRelocation;
    private Answer answerThereIsRelocation;
    private Answer answerThereIsNotRelocation;

    @Before
    public void setUp() {
        profile = new Profile();
    }

    @Before
    public void createQuestion() {
        questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
        answerThereIsRelocation = new Answer(questionIsThereRelocation, Bool.TRUE);
        answerThereIsNotRelocation = new Answer(questionIsThereRelocation, Bool.FALSE);
    }

    @Test
    public void matchesNothingWhenProfileEmpty() {
        Criterion criterion = new Criterion(new Answer(questionIsThereRelocation, Bool.TRUE), Weight.DontCare);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }

    @Test
    public void matchesWhenProfileContainsMatchingAnswer() {
        profile.add(answerThereIsRelocation);
        Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertTrue(result);
    }

    @Test
    public void doesNotMatchWhenNoMatchingAnswer() {
        profile.add(answerThereIsNotRelocation);
        Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }
}