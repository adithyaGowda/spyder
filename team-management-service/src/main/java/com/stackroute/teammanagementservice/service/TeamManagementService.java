package com.stackroute.teammanagementservice.service;

import com.stackroute.teammanagementservice.domain.Idea;
import com.stackroute.teammanagementservice.exception.IdeaTitleAlreadyExistException;

public interface TeamManagementService {
    /**
     * AbstractMethod to save a Idea
     */
    public Idea saveIdea(Idea idea) throws IdeaTitleAlreadyExistException;
    /**
     * AbstractMethod to update SelectedTeam of Idea
     */
    public Idea  updateSelectedTeam(Idea idea);

    /**
     * AbstractMethod to update AppliedTeam of Idea
     */
    public Idea updateAppliedTeam(Idea idea);

    /**
     * AbstractMethod to update InvitedTeam of Idea
     */
    public Idea updateInvitedTeam(Idea idea);

    /**
     * AbstractMethod to update if IH accepts particular SP from applied list, delete SP from aplied users and updated to selected team list
     */
   public  Idea acceptedsp(String tite,String emailId,boolean accepted);

    /**
     * AbstractMethod to update When SP joins invited ideas. Delete SP from invited list and add him to selected team list
     */
   public Idea joinsp(String title, String emailId, boolean joined);

    public  Idea getDetails(String title);
}
