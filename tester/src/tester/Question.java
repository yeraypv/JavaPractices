package tester;

/**
 *
 * @author yeray pérez valiente
 */
public class Question {

    private int position;
    private String validQuestion;
    private String question;
    private String[] alternatives;
    private boolean realizeQuestion = false;

    public Question() {

    }

    public Question(int position, String answer, String[] alternatives, String validQuestion) {
        this.question = answer;
        this.alternatives = alternatives;
        this.validQuestion = validQuestion;
        this.position = position;
    }

    public String getValidQuestion() {
        return validQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAlternatives() {
        return alternatives;
    }

    public int getPosition() {
        return position;
    }

    public boolean isRealizeQuestion() {
        return realizeQuestion;
    }

    public void setValidQuestion(String validQuestion) {
        this.validQuestion = validQuestion;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAlternatives(String[] alternatives) {
        this.alternatives = alternatives;
    }

    public void setRealizeQuestion(boolean realizeQuestion) {
        this.realizeQuestion = realizeQuestion;
    }

}
