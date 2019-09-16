package com.stackroute.squad.repository;

import com.stackroute.squad.domain.Roles;
import com.stackroute.squad.domain.ServiceProvider;
import com.stackroute.squad.domain.Skills;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
/*@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval,
 search, update and delete operation on objects.*/
@Repository
public interface RolesRepository extends Neo4jRepository<Roles, Long> {
  public Roles findById(long id);

}
