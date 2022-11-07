package com.solera.blockchainquestionare.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    private String question;

    @ManyToOne
    @JoinColumn(name = "fk_category")
    private Category category;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

    public Question() {
    }

    public Question(Integer id, String question) {
        this.id = id;
        this.question = question;
    }

    public Question(Integer id, String question, Category category) {
        this.id = id;
        this.question = question;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", category=" + category +
                '}';
    }
}
