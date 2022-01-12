package com.jpa.jpaexample.strategy.factory;

import com.jpa.jpaexample.model.StrategyName;
import com.jpa.jpaexample.strategy.SearchStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StrategyFactory {

    private Map<StrategyName, SearchStrategy> strategyMap=new HashMap<>();

    @Autowired
    private Set<SearchStrategy> searchStrategySet;

    @PostConstruct
    public void buildStrategyFactory(){
        System.out.println("searchStrategySet = " + searchStrategySet);
        searchStrategySet.stream().map(searchStrategy -> strategyMap.put(searchStrategy.getStrategyName(),searchStrategy)).collect(Collectors.toSet());
        System.out.println("strategyMap = " + strategyMap);
    }

    public SearchStrategy findStrategy(StrategyName strategyName) {
        return strategyMap.get(strategyName);

    }
}
