package com.stackroute.recommendedqueryservice.service;

import com.stackroute.recommendedqueryservice.domain.Idea;
import com.stackroute.recommendedqueryservice.domain.ServiceProvider;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface RecommendedeamService {
    List<ServiceProvider> getTeam(String title,String roleName);
    List<ServiceProvider> getTeamBasedOnAppliedIdea(String title,String roleName);
    List<ServiceProvider> getTeamBasedOnWorkedOnIdea(String title, String roleName);
    public List<ServiceProvider> getdata(String title,String roleName);
}
