package me.bactoria.TddProject.iloveyouboss;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Bactoria
 * @since 2019-11-13 [2019.11월.13]
 */

public class Profile_MatchesCriterionTest {

    private Profile profile;
    private Answer answerThereIsRelocation;
    private Answer answerThereIsNotRelocation;
    private Answer answerDoesNotReimburseTuition;
    private Answer answerReimbursesTuition;

    @Before
    public void setUp() {
        profile = new Profile();
    }

    @Before
    public void createQuestion() {
        BooleanQuestion questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
        BooleanQuestion questionReimbursesTuition = new BooleanQuestion(1, "Reimburses tuition?");

        answerThereIsRelocation = new Answer(questionIsThereRelocation, Bool.TRUE);
        answerThereIsNotRelocation = new Answer(questionIsThereRelocation, Bool.FALSE);
        answerDoesNotReimburseTuition = new Answer(questionReimbursesTuition, Bool.FALSE);
        answerReimbursesTuition = new Answer(questionReimbursesTuition, Bool.TRUE);
    }

    @Test
    public void trueWhenMatchesSoleAnswer() {
        profile.add(answerThereIsRelocation);
        Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertTrue(result);
    }

    @Test
    public void falseWhenNoMatchingAnswerContained() {
        profile.add(answerThereIsNotRelocation);
        Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }

    @Test
    public void trueWhenOneOfMultipleAnswerMatches() {
        profile.add(answerThereIsRelocation);
        profile.add(answerDoesNotReimburseTuition);
        Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertTrue(result);
    }

    @Test
    public void trueForAnyDontCareCriterion() {
        profile.add(answerDoesNotReimburseTuition);
        Criterion criterion = new Criterion(answerReimbursesTuition, Weight.DontCare);

        boolean result = profile.matches(criterion);

        assertTrue(result);
    }
}