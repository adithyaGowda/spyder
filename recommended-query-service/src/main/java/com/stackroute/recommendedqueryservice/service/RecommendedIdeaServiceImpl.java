package com.stackroute.recommendedqueryservice.service;

import com.stackroute.recommendedqueryservice.domain.Domain;
import com.stackroute.recommendedqueryservice.domain.Idea;
import com.stackroute.recommendedqueryservice.domain.IdeaHamster;
import com.stackroute.recommendedqueryservice.domain.SubDomain;
import com.stackroute.recommendedqueryservice.repository.IdeaRecommendationRepository;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class RecommendedIdeaServiceImpl implements RecommendedIdeaService {
    private IdeaRecommendationRepository ideaRecommendationRepository;

    @Autowired
    public RecommendedIdeaServiceImpl(IdeaRecommendationRepository ideaRecommendationRepository) {
        this.ideaRecommendationRepository = ideaRecommendationRepository;
    }

    @Override
    public List<Idea> findBySkill(String email) {
        return ideaRecommendationRepository.findBySkill(email);
    }

    @Override
    public List<Idea> findByRole(String email) {
        return ideaRecommendationRepository.findByRole(email);
    }

    @Override
    public List<Idea> findByWorkedOnIdea(String email) {

        return ideaRecommendationRepository.findByWorkedOnIdea(email);
    }

    @Override
    public List<Idea> findByAppliedOnIdea(String email) {
        return ideaRecommendationRepository.findByAppliedOnIdea(email);
    }


}
