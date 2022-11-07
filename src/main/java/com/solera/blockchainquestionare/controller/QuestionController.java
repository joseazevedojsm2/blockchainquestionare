package com.solera.blockchainquestionare.controller;

import com.solera.blockchainquestionare.entity.Question;
import com.solera.blockchainquestionare.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping("/all")
    public List<Question> retrieveAllQuestions(){
        return service.getAllQuestions();
    }

}
