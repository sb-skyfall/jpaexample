package com.jpa.jpaexample.strategy;

import com.jpa.jpaexample.model.StrategyName;
import com.jpa.jpaexample.model.User;

import java.util.List;

public interface SearchStrategy {

    public List<User> search(String keyword);

    public StrategyName getStrategyName();
}
