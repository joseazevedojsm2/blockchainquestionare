package com.solera.blockchainquestionare.service;

import com.solera.blockchainquestionare.entity.Answer;
import com.solera.blockchainquestionare.entity.Client;
import com.solera.blockchainquestionare.entity.Question;
import com.solera.blockchainquestionare.repository.AnswerRepository;
import com.solera.blockchainquestionare.repository.ClientRepository;
import com.solera.blockchainquestionare.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    private AnswerRepository repository;
    private ClientRepository clientRepository;
    private QuestionRepository questionRepository;
    @Autowired
    public AnswerService(AnswerRepository answerRepository, ClientRepository clientRepository, QuestionRepository questionRepository){
        repository = answerRepository;
        this.clientRepository = clientRepository;
        this.questionRepository = questionRepository;
    }


    public Client getClientByEmail(String useremail) {
        Optional<Client> client = clientRepository.findAll().stream()
                .filter(client1 ->  {
                    return client1.getEmail().equalsIgnoreCase(useremail);
                }).findFirst();

        if (client.isEmpty())
            return new Client();

        return client.get();
    }

    public Client createClient(String useremail) {
        if(useremail.isEmpty())
            return null;

        Client client = clientRepository.save(new Client(useremail));

        return client;
    }

    public Answer createAnswersByClient(String useremail, Answer answer) {
        Client client = getClientByEmail(useremail);

        if(client==null)
            return null;

        answer.setClient(client);

        Optional<Question> question = questionRepository.findAll().stream()
                .filter(question1 -> question1.getQuestion().equalsIgnoreCase(answer.getQuestion().getQuestion()))
                .findFirst();

        if(question.isEmpty())
            return null;

        answer.setQuestion(question.get());

        Answer newAnswer = repository.save(answer);

        return newAnswer;
    }

    public List<Answer> getAnswerByClient(String useremail) {
        Client client = getClientByEmail(useremail);

        if(client==null)
            return null;

        List<Answer> answer = repository.findAll().stream()
                .filter(answer1 -> answer1.getClient().getEmail().equalsIgnoreCase(useremail))
                .collect(Collectors.toList());

        if (answer.isEmpty())
            return null;

        return answer;
    }
}
