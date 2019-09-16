package com.stackroute.teammanagementservice.controller;
import com.stackroute.teammanagementservice.domain.Idea;
import com.stackroute.teammanagementservice.exception.IdeaTitleAlreadyExistException;
import com.stackroute.teammanagementservice.service.TeamManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * RestController annotation is used to create Restful web services using Spring MVC
 */

@CrossOrigin(origins = "*")
@RestController

/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RequestMapping(value = "/api/v1/")
public class TeamManagementController {
    private TeamManagementService teamManagementService;
    /**
     * Constructor based Dependency injection to inject TeamManagementService into controller
     */
    @Autowired
    public TeamManagementController(TeamManagementService teamManagementService) {
        this.teamManagementService = teamManagementService;
    }

    /**
     * PostMapping Annotation for mapping HTTP POST requests onto specific handler methods.
     */
    @PostMapping("idea")
    public ResponseEntity<?> postIdea(@RequestBody Idea idea) throws IdeaTitleAlreadyExistException {
        ResponseEntity responseEntity;
        teamManagementService.saveIdea(idea);
        responseEntity = new ResponseEntity<String>("sucessfully created", HttpStatus.CREATED);
        return responseEntity;
    }


    /**
     * PutMapping Annotation for mapping HTTP PuT requests onto specific handler methods.
     * updates SelectedTeam When User Requests To Update SelectedTeam.
     */
    @PutMapping("selectedTeam")
    public ResponseEntity<?> updateIdea(@RequestBody Idea idea)  {
        Idea updatedSelectedTeam = teamManagementService.updateSelectedTeam(idea);
        return new ResponseEntity<>(updatedSelectedTeam, HttpStatus.ACCEPTED);
    }


    /**
     * PutMapping Annotation for mapping HTTP PuT requests onto specific handler methods.
     * updates AppliedTeam When User Requests To update AppliedTeam.
     */
    @PutMapping("appliedTeam")
    public ResponseEntity<?> updateAppliedTeam(@RequestBody Idea idea){
        Idea updatedAppliedTeam = teamManagementService.updateAppliedTeam(idea);
        return new ResponseEntity<>(updatedAppliedTeam, HttpStatus.ACCEPTED);
    }


    /**
     * PutMapping Annotation for mapping HTTP PuT requests onto specific handler methods.
     * updates InvitedTeam When User Requests To Update InvitedTeam.
     */
    @PutMapping("invitedTeam")
    public ResponseEntity<?> updateInvitedTeam(@RequestBody Idea idea){
        Idea updatedInvitedTeam = teamManagementService.updateInvitedTeam(idea);
        return new ResponseEntity<>(updatedInvitedTeam, HttpStatus.ACCEPTED);
    }


    /**
     * PutMapping Annotation for mapping HTTP PuT requests onto specific handler methods.
     * updates SelectedTeamList, When IH accepts particular SP from applied list, delete SP from aplied users and updated to selected team list and if IH rejects, delete from applied team list
     * It Takes title,emailId and boolean status to delete and update particular ServiceProvider.
     */
    @PutMapping("acceptssp")
    public ResponseEntity<?> acceptServiceProvider(@RequestParam("title") String title, @RequestParam("emailId") String emailId,@RequestParam boolean accepted){
        Idea acceptedsp = teamManagementService.acceptedsp(title,emailId,accepted);
        return new ResponseEntity<>(acceptedsp, HttpStatus.ACCEPTED);

    }


    /**
     * PutMapping Annotation for mapping HTTP PuT requests onto specific handler methods.
     * updates SelectedTeamList, When SP joins invited ideas. Delete SP from invited list and add him to selected team list
     * It Takes title,emailId and boolean status to delete and update particular ServiceProvider.
     */
    @PutMapping("joinedsp")
    public ResponseEntity<?> joinedServiceProvider(@RequestParam("title") String title,@RequestParam("emailId") String emailId,@RequestParam boolean joined){
        Idea joinedsp = teamManagementService.joinsp(title,emailId,joined);
        return new ResponseEntity<>(joinedsp,HttpStatus.ACCEPTED);
    }


    @GetMapping("idea/{title}")
    public ResponseEntity<?> getIdeaDetails(@PathVariable String title){
        Idea retrievedDetails = teamManagementService.getDetails(title);
        return new ResponseEntity<>(retrievedDetails,HttpStatus.ACCEPTED);
    }

}
