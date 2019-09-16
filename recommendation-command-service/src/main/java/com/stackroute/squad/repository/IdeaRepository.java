package com.stackroute.squad.repository;

import com.stackroute.squad.domain.Idea;
import com.stackroute.squad.domain.Roles;
import com.stackroute.squad.domain.ServiceProvider;
import com.stackroute.squad.domain.SubDomain;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/*@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval,
 search, update and delete operation on objects.*/
@Repository
public interface IdeaRepository extends Neo4jRepository<Idea, Long> {
  public Idea findById(long id);
  public Idea deleteByTitle(String title);
//Query for idea requires roles
 @Query("MATCH (x:Idea),(y:Roles) WHERE x.title={title} and y.roleName={roleName} CREATE (x)-[r:requires]->(y) RETURN x")
 public Idea setRequiresRelation(@Param("title")String title, @Param("roleName")String roleName);

//Query for idea belongs to subdomain
 @Query("MATCH (i:Idea),(s:subdomain) WHERE i.title={title} and s.name={name} CREATE (i)-[b:belongs_to]->(s) RETURN i")
  public Idea setBelongsToRelation(@Param("title")String title, @Param("name")String name);
//Query for idea needs skills
  @Query("MATCH (i:Idea),(sk:skills) WHERE i.title={title} and sk.name={name} CREATE (i)-[h:need]->(sk) RETURN i")
  public Idea setNeedsRelation(@Param("title")String title, @Param("name") String name);
//Query for deleting the idea based on roles
  @Query("MATCH (x:Idea),(y:Roles) WHERE x.title={title} and y.roleName={roleName} OPTIONAL MATCH (x)-[r:requires]-(y) DETACH DELETE x,r RETURN x")
  public Idea deleteRequiresRelation(@Param("title")String title, @Param("roleName")String roleName);

}
