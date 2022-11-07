package com.solera.blockchainquestionare.entity;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer points;
    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_question")
    private Question question;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_client")
    private Client client;

    public Answer() {
    }

    public Answer(Integer id, Integer points) {
        this.id = id;
        this.points = points;
    }

    public Answer(Integer id, Question question, Client client) {
        this.id = id;
        this.question = question;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", points=" + points +
                ", question=" + question +
                ", client=" + client +
                '}';
    }
}
