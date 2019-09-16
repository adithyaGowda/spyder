package com.stackroute.recommendedqueryservice.service;

import com.stackroute.recommendedqueryservice.domain.Domain;
import com.stackroute.recommendedqueryservice.domain.Idea;
import com.stackroute.recommendedqueryservice.domain.IdeaHamster;
import com.stackroute.recommendedqueryservice.domain.SubDomain;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

public interface RecommendedIdeaService {
    List<Idea> findBySkill(String email);

    List<Idea> findByRole(String email);

    List<Idea> findByWorkedOnIdea(String email);

    List<Idea> findByAppliedOnIdea(String email);
}
