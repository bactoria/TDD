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
    private Criteria criteria;
    private BooleanQuestion questionIsThereRelocation;
    private BooleanQuestion questionReimbursesTuition;
    private Answer answerThereIsRelocation;
    private Answer answerThereIsNotRelocation;
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
        questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
        answerThereIsRelocation = new Answer(questionIsThereRelocation, Bool.TRUE);
        answerThereIsNotRelocation = new Answer(questionIsThereRelocation, Bool.FALSE);

        questionReimbursesTuition = new BooleanQuestion(1, "Reimburses tuition?");
        answerDoesNotReimburseTuition =
                new Answer(questionReimbursesTuition, Bool.FALSE);
        answerReimbursesTuition =
                new Answer(questionReimbursesTuition, Bool.TRUE);
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

    @Test
    public void matchesWhenContainsMultipleAnswers() {
        profile.add(answerThereIsRelocation);
        profile.add(answerDoesNotReimburseTuition);
        Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertTrue(result);
    }

    @Test
    public void doesNotMatchWhenNoneOfMultipleCriteriaMatch() {
        profile.add(answerDoesNotReimburseTuition);
        criteria.add(new Criterion(answerThereIsRelocation, Weight.Important));
        criteria.add(new Criterion(answerReimbursesTuition, Weight.Important));

        boolean result = profile.matches(criteria);

        assertFalse(result);
    }

    @Test
    public void matchWhenAnyOfMultipleCriteriaMatch() {
        profile.add(answerThereIsRelocation);
        criteria.add(new Criterion(answerThereIsRelocation, Weight.Important));
        criteria.add(new Criterion(answerReimbursesTuition, Weight.Important));

        boolean result = profile.matches(criteria);

        assertTrue(result);
    }

    @Test
    public void doesNotMatchWhenAnyMustMeetCriteriaNotMet() {
        profile.add(answerThereIsRelocation);
        criteria.add(new Criterion(answerThereIsRelocation, Weight.Important));
        criteria.add(new Criterion(answerReimbursesTuition, Weight.MustMatch));

        boolean result = profile.matches(criteria);

        assertFalse(result);
    }

    @Test
    public void matchesWhenCriterionIsDontCare() {
        profile.add(answerDoesNotReimburseTuition);
        Criterion criterion = new Criterion(answerReimbursesTuition, Weight.DontCare);

        boolean result = profile.matches(criterion);

        assertTrue(result);
    }
}