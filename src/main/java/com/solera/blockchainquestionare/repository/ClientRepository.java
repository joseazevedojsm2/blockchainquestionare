package com.solera.blockchainquestionare.repository;

import com.solera.blockchainquestionare.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
