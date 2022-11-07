package com.solera.blockchainquestionare.repository;

import com.solera.blockchainquestionare.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
