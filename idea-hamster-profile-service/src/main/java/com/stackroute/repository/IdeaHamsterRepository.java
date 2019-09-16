package com.stackroute.repository;

import com.stackroute.domain.Idea;
import com.stackroute.domain.IdeaHamster;
import org.bouncycastle.jcajce.provider.symmetric.IDEA;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaHamsterRepository extends MongoRepository<IdeaHamster,String> {

    public IdeaHamster findByEmail(String email);


}
