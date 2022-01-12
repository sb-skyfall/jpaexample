package com.jpa.jpaexample.strategy.impl;


import com.jpa.jpaexample.dao.UserRepository;
import com.jpa.jpaexample.model.StrategyName;
import com.jpa.jpaexample.model.User;
import com.jpa.jpaexample.strategy.SearchStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SearchByName implements SearchStrategy {


    private final UserRepository userRepository;

    public SearchByName(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> search(String keyword) {
        return userRepository.findByName(keyword);
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.SearchByName;
    }
}
