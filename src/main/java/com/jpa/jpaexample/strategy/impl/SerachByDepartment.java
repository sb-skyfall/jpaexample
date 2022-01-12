package com.jpa.jpaexample.strategy.impl;

import com.jpa.jpaexample.dao.UserRepository;
import com.jpa.jpaexample.model.StrategyName;
import com.jpa.jpaexample.model.User;
import com.jpa.jpaexample.strategy.SearchStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SerachByDepartment implements SearchStrategy {


    private final UserRepository userRepository;

    public SerachByDepartment(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> search(String keyword) {
        return userRepository.findByDepartment(keyword);
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.SearchByDepartment;
    }
}
