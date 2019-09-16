package com.stackroute.repository;

import com.stackroute.domain.SearchServiceProvider;
import com.stackroute.domain.ServiceProvider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchServiceProviderRepository extends MongoRepository<SearchServiceProvider,Integer> {

    SearchServiceProvider findByRoleName(String roleName);
}
