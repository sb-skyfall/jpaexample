package com.jpa.jpaexample.service;


import com.jpa.jpaexample.dao.UserRepository;
import com.jpa.jpaexample.model.StrategyName;
import com.jpa.jpaexample.model.User;
import com.jpa.jpaexample.strategy.SearchStrategy;
import com.jpa.jpaexample.strategy.factory.StrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private StrategyFactory strategyFactory;

    @Value("${search.strategy}")
    private String searchStrategyName;

    @PostConstruct
    public void initDB(){
        List<User> users=new ArrayList<>();
        users.add(new User("111","SB","CSE",26));
        users.add(new User("222","BB","CSE",52));
        users.add(new User("333","LSB","CSE",61));
        users.add(new User("444","RB","CSE",26));

        users=users.stream().map(user -> {
            user.setId(UUID.randomUUID().toString());
            return user;
        }).collect(Collectors.toList());
        if(userRepo.count()==0){
            userRepo.saveAll(users);
        }

    }
    public List<User> getUsersByStrategy(String keyword){

        SearchStrategy searchStrategy=strategyFactory.findStrategy(StrategyName.getEnum(searchStrategyName));
        return searchStrategy.search(keyword);
    }

    public List<User> getAllUsersFromDB()
    {
        return userRepo.findAll();
    }
}
