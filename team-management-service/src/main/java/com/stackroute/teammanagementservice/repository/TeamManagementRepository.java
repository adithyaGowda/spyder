package com.stackroute.teammanagementservice.repository;

import com.stackroute.teammanagementservice.domain.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * @Repository marks the specific class as a Data Access Object
 */
@Repository
public interface TeamManagementRepository extends MongoRepository<Idea,String> {
    /**findBytitleName method to get title by its name*/
    Idea findByTitle(String title);
}

