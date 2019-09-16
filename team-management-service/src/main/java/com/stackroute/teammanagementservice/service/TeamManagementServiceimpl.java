package com.stackroute.teammanagementservice.service;

import com.stackroute.teammanagementservice.domain.Idea;
import com.stackroute.teammanagementservice.domain.ServiceProvider;
import com.stackroute.teammanagementservice.dto.IdeaDto;
import com.stackroute.teammanagementservice.exception.IdeaTitleAlreadyExistException;
import com.stackroute.teammanagementservice.repository.TeamManagementRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:application.properties")

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service

public class TeamManagementServiceimpl implements TeamManagementService {
    private TeamManagementRepository teamManagementRepository;
    /**
     * Constructor based Dependency injection to inject TeamManagementRepository here
     */
    @Autowired
    public TeamManagementServiceimpl(TeamManagementRepository teamManagementRepository) {
        this.teamManagementRepository = teamManagementRepository;
    }

    /**
     * Implementation of saveIdea method
     */
    @Override
    public Idea saveIdea(Idea idea) throws IdeaTitleAlreadyExistException {
        /**Throw IdeaTitleAlreadyExistException if title already exists*/
        if (teamManagementRepository.findByTitle(idea.getTitle()) != null) {
            throw new IdeaTitleAlreadyExistException("Title Already Exists");
        }
        Idea savedIdea = teamManagementRepository.save(idea);
        return savedIdea;
    }
    /**
     * Implementation of updateSelectedTeam method
     */
    @Override
    public Idea updateSelectedTeam(Idea idea) {
        Idea retrievedIdea = teamManagementRepository.findByTitle(idea.getTitle());
        List<ServiceProvider> serviceProviders = new ArrayList<>();
        serviceProviders = idea.getSelectedTeam();
        retrievedIdea.setSelectedTeam(serviceProviders);
        return teamManagementRepository.save(retrievedIdea);
    }
    /**
     * Implementation of updateAppliedTeam method
     */
    @Override
    public Idea updateAppliedTeam(Idea idea) {
        Idea retrievedIdea = teamManagementRepository.findByTitle(idea.getTitle());
        List<ServiceProvider> serviceProviders;
        if (retrievedIdea.getAppliedTeam() == null) {
            serviceProviders = new ArrayList<>();
        } else {
            serviceProviders = retrievedIdea.getAppliedTeam();
        }
        serviceProviders.add(idea.getAppliedTeam().get(0));
        return teamManagementRepository.save(retrievedIdea);
    }
    /**
     * Implementation of updateInvitedTeam method
     */
    @Override
    public Idea updateInvitedTeam(Idea idea) {
        Idea retrievedIdea = teamManagementRepository.findByTitle(idea.getTitle());
        List<ServiceProvider> serviceProviders;
        if (retrievedIdea.getInvitedTeam() == null) {
            serviceProviders = new ArrayList<>();
        } else {
            serviceProviders = retrievedIdea.getInvitedTeam();
        }
        serviceProviders.add(idea.getInvitedTeam().get(0));
        return teamManagementRepository.save(retrievedIdea);
    }

    /**
     * Implementation of acceptedsp/rejectedsp method
     */
    @Override
    public Idea acceptedsp(String title, String emailId, boolean accepted) {
        Idea retrievedIdea = teamManagementRepository.findByTitle(title);
        List<ServiceProvider> appliedList = retrievedIdea.getAppliedTeam();
        List<ServiceProvider> selectedList = retrievedIdea.getSelectedTeam();
        Idea updatedIdea = null;
        if (accepted) {
            for (int i = 0; i < appliedList.size(); i++) {
                if (appliedList.get(i).getEmailId().equals(emailId)) {
                    selectedList.add(appliedList.get(i));
                    retrievedIdea.setSelectedTeam(selectedList);
                    appliedList.remove(i);
                     updatedIdea = teamManagementRepository.save(retrievedIdea);
                }
            }
        }
        else {
            for (int i = 0; i < appliedList.size(); i++) {
                if (appliedList.get(i).getEmailId().equals(emailId)) {
                    appliedList.remove(i);
                     updatedIdea = teamManagementRepository.save(retrievedIdea);
                }
            }

        }
        return updatedIdea;
    }
    /**
     * Implementation of joinedsp method
     */
    @Override
    public Idea joinsp(String title,String emailId,boolean joined){
        Idea retrievedIdea = teamManagementRepository.findByTitle(title);
        List<ServiceProvider> invitedList = retrievedIdea.getInvitedTeam();
        List<ServiceProvider> selectedList = retrievedIdea.getSelectedTeam();
        Idea updatedIdea = null;
        if(joined){
            for(int i = 0;i < invitedList.size();i++){
                if(invitedList.get(i).getEmailId().equals(emailId)){
                    selectedList.add(invitedList.get(i));
                    retrievedIdea.setSelectedTeam(selectedList);
                    invitedList.remove(i);
                    updatedIdea = teamManagementRepository.save(retrievedIdea);
                }
            }
        }
        else{
            for(int i = 0; i<invitedList.size();i++){
                if(invitedList.get(i).getEmailId().equals(emailId)){
                    invitedList.remove(i);
                    updatedIdea = teamManagementRepository.save(retrievedIdea);
                }
            }
        }
        return updatedIdea;
    }

    /**
     * Annotation listens to the queue name called idea and store it in database
     */
    @RabbitListener(queues = "${idea.rabbitmq.queue}")
    public void receive(IdeaDto ideaDTO) {

        Idea idea = new Idea();
        idea.setTitle(ideaDTO.getTitle());
        idea.setDescription(ideaDTO.getDescription());
        idea.setDuration(ideaDTO.getDuration());
        idea.setDomain(ideaDTO.getDomain());
        idea.setCost(ideaDTO.getCost());
        idea.setRole(ideaDTO.getRole());
        idea.setStatus(ideaDTO.getStatus());
        idea.setLocation(ideaDTO.getLocation());
        teamManagementRepository.save(idea);
    }

    @Override
    public Idea getDetails(String title) {
        Idea  retrievedIdea = teamManagementRepository.findByTitle(title);
        return retrievedIdea;
    }

}
