package com.solera.blockchainquestionare.repository;

import com.solera.blockchainquestionare.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
