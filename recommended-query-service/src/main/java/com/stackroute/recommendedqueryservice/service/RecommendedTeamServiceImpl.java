package com.stackroute.recommendedqueryservice.service;

import com.stackroute.recommendedqueryservice.domain.Idea;
import com.stackroute.recommendedqueryservice.domain.ServiceProvider;
import com.stackroute.recommendedqueryservice.repository.TeamRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RecommendedTeamServiceImpl implements RecommendedeamService {
    private TeamRecommendationRepository teamRecommendationRepository;
    List<ServiceProvider> x;

    @Autowired
    public RecommendedTeamServiceImpl(TeamRecommendationRepository teamRecommendationRepository,List<ServiceProvider> x) {
        this.teamRecommendationRepository = teamRecommendationRepository;
        this.x=x;
    }

    @Override
    public List<ServiceProvider> getTeam(String title, String roleName) {
        List<ServiceProvider> serviceProvider1 = teamRecommendationRepository.getTeam(title, roleName);
    return serviceProvider1;
       }

    @Override
    public List<ServiceProvider> getTeamBasedOnAppliedIdea(String title, String roleName) {
        List<ServiceProvider> sp=teamRecommendationRepository.getTeamBasedOnAppliedIdea(roleName, title);
        return sp;
    }

    @Override
    public List<ServiceProvider> getTeamBasedOnWorkedOnIdea(String title, String roleName) {
        List<ServiceProvider> serviceProvider2 = teamRecommendationRepository.getTeamBasedOnWorkedOnIdea(title, roleName);
        return serviceProvider2;
    }

    @Override
    public List<ServiceProvider> getdata(String title, String roleName) {
                List<ServiceProvider> sp1=teamRecommendationRepository.getTeam(title, roleName);
        List<ServiceProvider> sp2=teamRecommendationRepository.getTeamBasedOnWorkedOnIdea(title, roleName);
        List<ServiceProvider> sp3=teamRecommendationRepository.getTeamBasedOnAppliedIdea(title, roleName);
        x.addAll(sp1);
         int da=sp1.size();
        System.out.println(da);

     System.out.println(x);
        sp1.addAll(sp2);
     System.out.println(x);
        sp1.addAll(sp3);
     System.out.println(x);
        return x;
    }

}
