package com.company.U1M4SummativeInciarteAndres.model;

import javax.validation.constraints.NotEmpty;

public class Answer {
    @NotEmpty(message = "Please enter a question")
    private String question;
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
