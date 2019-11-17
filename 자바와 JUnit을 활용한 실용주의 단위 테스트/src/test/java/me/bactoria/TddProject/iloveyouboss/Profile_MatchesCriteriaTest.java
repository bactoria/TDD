package me.bactoria.TddProject.iloveyouboss;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Bactoria
 * @since 2019-11-13 [2019.11월.13]
 */

public class Profile_MatchesCriteriaTest {

    private Profile profile;
    private Criteria criteria;
    private Answer answerThereIsRelocation;
    private Answer answerDoesNotReimburseTuition;
    private Answer answerReimbursesTuition;

    @Before
    public void setUp() {
        profile = new Profile();
    }

    @Before
    public void createCriteria() {
        criteria = new Criteria();
    }

    @Before
    public void createQuestion() {
        BooleanQuestion questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
        BooleanQuestion questionReimbursesTuition = new BooleanQuestion(1, "Reimburses tuition?");

        answerThereIsRelocation = new Answer(questionIsThereRelocation, Bool.TRUE);
        answerDoesNotReimburseTuition = new Answer(questionReimbursesTuition, Bool.FALSE);
        answerReimbursesTuition = new Answer(questionReimbursesTuition, Bool.TRUE);
    }

    @Test
    public void falseWhenNoneOfMultipleCriteriaMatch() {
        profile.add(answerDoesNotReimburseTuition);
        criteria.add(new Criterion(answerThereIsRelocation, Weight.Important));
        criteria.add(new Criterion(answerReimbursesTuition, Weight.Important));

        boolean result = profile.matches(criteria);

        assertFalse(result);
    }

    @Test
    public void trueWhenAnyOfMultipleCriteriaMatch() {
        profile.add(answerThereIsRelocation);
        criteria.add(new Criterion(answerThereIsRelocation, Weight.Important));
        criteria.add(new Criterion(answerReimbursesTuition, Weight.Important));

        boolean result = profile.matches(criteria);

        assertTrue(result);
    }

    @Test
    public void falseWhenAnyMustMeetCriteriaNotMet() {
        profile.add(answerThereIsRelocation);
        criteria.add(new Criterion(answerThereIsRelocation, Weight.Important));
        criteria.add(new Criterion(answerReimbursesTuition, Weight.MustMatch));

        boolean result = profile.matches(criteria);

        assertFalse(result);
    }

}