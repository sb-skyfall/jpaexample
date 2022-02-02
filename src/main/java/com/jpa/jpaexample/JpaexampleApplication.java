package com.jpa.jpaexample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpaexampleApplication {

	/*@Qualifier("searchByAll")
	private SearchStrategy searchByAll;

	@Qualifier("searchByName")
	private SearchStrategy searchByName;

	@Qualifier("searchByDepartment")
	private SearchStrategy searchByDepartment;*/



	public static void main(String[] args) {
		SpringApplication.run(JpaexampleApplication.class, args);
	}

//	@Bean
//	public Set<SearchStrategy> searchStrategySet(){
//		Set<SearchStrategy> searchStrategySet=new HashSet<>();
//		searchStrategySet.add(searchByName);
//		searchStrategySet.add(searchByAll);
//		searchStrategySet.add(searchByDepartment);
//		return searchStrategySet;
//	}

}
