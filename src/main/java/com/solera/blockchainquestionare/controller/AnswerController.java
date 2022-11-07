package com.solera.blockchainquestionare.controller;

import com.solera.blockchainquestionare.entity.Answer;
import com.solera.blockchainquestionare.entity.Client;
import com.solera.blockchainquestionare.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@CrossOrigin
public class AnswerController {

    @Autowired
    private AnswerService service;

    @GetMapping("/{useremail}")
    public Client retrieveClientByUserEmail(@PathVariable String useremail){
        return service.getClientByEmail(useremail);
    }

    @PostMapping("/{useremail}")
    public Client insertClient(@PathVariable String useremail){
        return service.createClient(useremail);
    }

    @PostMapping("/{useremail}/answers")
    public Answer insertAnswerByUser(@PathVariable String useremail, @RequestBody Answer answer){
        return service.createAnswersByClient(useremail, answer);
    }

    @GetMapping("/{useremail}/answers")
    public List<Answer> retrieveAnswersByUser(@PathVariable String useremail){
        return  service.getAnswerByClient(useremail);
    }
}
