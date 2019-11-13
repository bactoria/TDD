package me.bactoria.TddProject.iloveyouboss;

/**
 * @author Bactoria
 * @since 2019-11-13 [2019.11월.13]
 */

public class Profile {
    private Answer answer;

    public boolean matches(Criterion criterion) {
        return answer != null;
    }

    public void add(Answer answer) {
        this.answer = answer;
    }
}
