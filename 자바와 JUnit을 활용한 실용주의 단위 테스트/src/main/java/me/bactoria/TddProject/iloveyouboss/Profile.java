package me.bactoria.TddProject.iloveyouboss;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bactoria
 * @since 2019-11-13 [2019.11월.13]
 */

public class Profile {
    private Map<String, Answer> answers = new HashMap<>();

    public boolean matches(Criteria criteria) {
        boolean matches = false;
        for (Criterion criterion: criteria) {
            if (matches(criterion)) {
                matches = true;
            } else if (criterion.getWeight() == Weight.MustMatch) {
                return false;
            }
        }
        return matches;
    }

    public boolean matches(Criterion criterion) {
        return
                criterion.getWeight() == Weight.DontCare ||
                criterion.getAnswer().match(getMatchingProfileAnswer(criterion));
    }

    private Answer getMatchingProfileAnswer(Criterion criterion) {
        return answers.get(criterion.getAnswer().getQuestionText());
    }

    public void add(Answer answer) {
        answers.put(answer.getQuestionText(), answer);
    }
}
