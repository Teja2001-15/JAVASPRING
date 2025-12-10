package com.example.communitysavings.service;

import com.example.communitysavings.model.SavingsGroup;
import com.example.communitysavings.repository.SavingsGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsGroupService {

    private final SavingsGroupRepository repository;

    public SavingsGroupService(SavingsGroupRepository repository) {
        this.repository = repository;
    }

    public SavingsGroup createGroup(SavingsGroup group) {
        return repository.save(group);
    }

    public Optional<SavingsGroup> findById(String id) {
        return repository.findById(id);
    }

    public List<SavingsGroup> findAll() {
        return repository.findAll();
    }
}
