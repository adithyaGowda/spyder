package com.stackroute.recommendedqueryservice.repository;

import com.stackroute.recommendedqueryservice.domain.*;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IdeaRecommendationRepository extends Neo4jRepository<Idea, Long> {

    @Query("MATCH(i:Idea),(sp:ServiceProvider)-[h:has_skill]->(s:Skills) with i,collect(s) as skills" +
            " match (sp)-[h:has_skill]-(s)<-[n:needs]-(i) where sp.email={email} return i")
    List<Idea> findBySkill(@Param("email") String email);

    //The above method gives all idea with the desired skill'
    @Query("MATCH (sp:ServiceProvider)<-[h:played_by]-(r:Roles)<-[n:requires]-(i) where sp.email={email} return i")
    List<Idea> findByRole(@Param("email") String email);

    //The above method gives all idea with the desired role
    @Query("match (ro:Roles)-[pl:played_by]->(s:ServiceProvider)-[w:worked_on]->(i:Idea)," +
            "(i:Idea)-[r:requires]->(ro:Roles)<-[re:requires]-(rec:Idea) " +
            "where not((s:ServiceProvider)-[w:worked_on]->(rec:Idea)) and s.email={email} return distinct rec")
    List<Idea> findByWorkedOnIdea(@Param("email") String email);

    @Query("match (ro:Roles)-[pl:played_by]->(s:ServiceProvider)-[w:applied_for]->(i:Idea)," +
            "(i:Idea)-[r:requires]->(ro:Roles)<-[re:requires]-(rec:Idea) where not" +
            "((s:ServiceProvider)-[w:applied_for]->(rec:Idea)) and s.email={email} return distinct rec")
    List<Idea> findByAppliedOnIdea(@Param("email") String email);

}
