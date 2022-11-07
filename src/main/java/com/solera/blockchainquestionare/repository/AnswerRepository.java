package com.solera.blockchainquestionare.repository;

import com.solera.blockchainquestionare.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
}
