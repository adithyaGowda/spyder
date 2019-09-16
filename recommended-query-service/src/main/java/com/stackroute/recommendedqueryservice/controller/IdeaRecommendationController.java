package com.stackroute.recommendedqueryservice.controller;

import com.stackroute.recommendedqueryservice.domain.*;
import com.stackroute.recommendedqueryservice.service.RecommendedIdeaService;
import com.stackroute.recommendedqueryservice.service.RecommendedeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/")
public class IdeaRecommendationController {
    private RecommendedIdeaService recommendedIdeaService;
    private RecommendedeamService recommendedeamService;

    @Autowired
    public IdeaRecommendationController(RecommendedIdeaService recommendedIdeaService, RecommendedeamService recommendedeamService) {
        this.recommendedIdeaService = recommendedIdeaService;
        this.recommendedeamService = recommendedeamService;
    }


    @GetMapping("skill/{email}")
    public ResponseEntity<Collection<Idea>> getIdeasBySkill(@PathVariable("email") String email) {
        List<Idea> Ideas = recommendedIdeaService.findBySkill(email);
        return new ResponseEntity<>(Ideas, HttpStatus.OK);
    }

    @GetMapping("role/{email}")
    public ResponseEntity<Iterable<Idea>> getIdeasByRole(@PathVariable("email") String email) {
        Iterable<Idea> ideas = recommendedIdeaService.findByRole(email);
        return new ResponseEntity<>(ideas, HttpStatus.OK);
    }

    @GetMapping("workedonIdea/{email}")
    public ResponseEntity<Iterable<Idea>> getIdeasByPreviousWork(@PathVariable("email") String name) {
        Iterable<Idea> ideas = recommendedIdeaService.findByWorkedOnIdea(name);
        return new ResponseEntity<>(ideas, HttpStatus.OK);
    }

    @GetMapping("appliedonIdea/{email}")
    public ResponseEntity<Iterable<Idea>> getIdeasByPreviousApplied(@PathVariable("email") String email) {
        Iterable<Idea> ideas = recommendedIdeaService.findByAppliedOnIdea(email);
        return new ResponseEntity<>(ideas, HttpStatus.OK);
    }

    @GetMapping("sp/{title}")
    public ResponseEntity<Collection<ServiceProvider>> getTeam(@PathVariable("title") String title, @RequestParam("roleName") String rname) {
        List<ServiceProvider> serviceProviders = recommendedeamService.getTeam(title, rname);
        return new ResponseEntity<>(serviceProviders, HttpStatus.OK);
    }
    @GetMapping("previouslyWorked/{title}")
    public ResponseEntity<?> getautoTeam(@PathVariable("title") String title,@RequestParam("roleName") String roleName) {
        List<ServiceProvider> serviceProviders = recommendedeamService.getTeamBasedOnWorkedOnIdea(title, roleName);

        return new ResponseEntity<>(serviceProviders, HttpStatus.OK);
    }
    @GetMapping("applied/{title}")
    public ResponseEntity<Collection<ServiceProvider>> getautoTeamrec(@PathVariable("title") String title, @RequestParam("roleName") String roleName) {
        Collection<ServiceProvider> serviceProviders = recommendedeamService.getdata(title, roleName);
        return new ResponseEntity<>(serviceProviders, HttpStatus.OK);
    }

}


