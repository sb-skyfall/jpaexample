package com.jpa.jpaexample.strategy.impl;

import com.jpa.jpaexample.dao.UserRepository;
import com.jpa.jpaexample.model.StrategyName;
import com.jpa.jpaexample.model.User;
import com.jpa.jpaexample.strategy.SearchStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class SearchByAll implements SearchStrategy {

    private final UserRepository userRepository;

    public SearchByAll(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> search(String keyword) {
        return userRepository.findAll().stream().
                filter(user -> user.toString().toLowerCase().contains(keyword.toLowerCase(Locale.ROOT))).
                collect(Collectors.toList());
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.SearchByAll;
    }
}
