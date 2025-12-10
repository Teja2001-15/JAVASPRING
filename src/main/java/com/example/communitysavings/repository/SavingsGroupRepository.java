package com.example.communitysavings.repository;

import com.example.communitysavings.model.SavingsGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SavingsGroupRepository extends MongoRepository<SavingsGroup, String> {
}
