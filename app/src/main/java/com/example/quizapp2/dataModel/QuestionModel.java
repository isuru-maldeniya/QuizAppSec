package com.example.quizapp2.dataModel;

public class QuestionModel {
    String question;
    String a;
    String b;
    String c;
    String d;
    String num;

    public QuestionModel() {
    }

    public QuestionModel(String question, String a, String b, String c, String d, String num) {
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.num = num;
    }

    public String getQuestion() {
        return question;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public String getNum() {
        return num;
    }
}
