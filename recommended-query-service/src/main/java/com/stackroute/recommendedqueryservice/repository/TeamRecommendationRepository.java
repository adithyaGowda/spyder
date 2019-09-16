package com.stackroute.recommendedqueryservice.repository;

import com.stackroute.recommendedqueryservice.domain.Idea;
import com.stackroute.recommendedqueryservice.domain.ServiceProvider;
import com.stackroute.recommendedqueryservice.domain.SubDomain;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TeamRecommendationRepository extends Neo4jRepository<SubDomain, Long> {
    @Query("match(r:Roles)-[p:played_by]->(sp:ServiceProvider)," +
            "(i:Idea)-[re:requires]->(r:Roles)-[h:have]->(s:Skills) where " +
            "i.title={title} and r.roleName={roleName} return sp order by sp.experience desc ")
    List<ServiceProvider> getTeam(@Param("title") String title, @Param("roleName") String roleName);

    @Query("match (olr:Roles)-[p:played_by]->(s:ServiceProvider)-[w:worked_on]->(i:Idea)," +
            "(i:Idea)-[r:requires]->(ro:Roles)-[ha:have]->(n:Skills)<-[hav:have]-(re:Roles)<-[req:requires]-" +
            "(rec:Idea) where not((s:ServiceProvider)-[w:worked_on]->(rec:Idea)) and olr.roleName={roleName} and" +
            " rec.title={title} with s, collect(n) as na unwind na as ski match (i:Idea)-[r:requires]->(ro:Roles)" +
            "-[ha:have]->(n:Skills)<-[hav:have]-(re:Roles)<-[req:requires]-(rec:Idea) " +
            "  return distinct s order by s.experience desc")
    List<ServiceProvider> getTeamBasedOnWorkedOnIdea(@Param("title") String title, @Param("roleName") String roleName);

@Query("match (olr:Roles)-[p:played_by]->(s:ServiceProvider)-[w:applied_for]->(i:Idea)," +
        "(i:Idea)-[r:requires]->(ro:Roles)-[ha:have]->(n:Skills)" +
        "<-[hav:have]-(re:Roles)<-[req:requires]-(rec:Idea) where not((s:ServiceProvider)-[w:worked_on]" +
        "->(rec:Idea)) and olr.roleName={roleName} and rec.title={title} with s, collect(n) as na" +
        " unwind na as ski match (i:Idea)-[r:requires]->(ro:Roles)" +
        "-[ha:have]->(n:Skills)<-[hav:have]-(olr:Roles)<-[req:requires]-(rec:Idea)" +
        " where olr.roleName={roleName}  return distinct s order by s.experience desc")
List<ServiceProvider> getTeamBasedOnAppliedIdea(@Param("roleName") String rname,@Param("title") String title);


}