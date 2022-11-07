package com.solera.blockchainquestionare.service;

import com.solera.blockchainquestionare.entity.Question;
import com.solera.blockchainquestionare.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository repository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository){
        this.repository = questionRepository;
    }


    public List<Question> getAllQuestions() {
        List<Question> questions = repository.findAll();
        if(questions.isEmpty())
            return null;

        return questions;
    }
}
