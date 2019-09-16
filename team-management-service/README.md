This File Contains About TeamManagementService 
-> This Service Is Able To Manage The List Of ServiceProviders(AppliedTeamList,SelectedTeamList,InvitedTeamList).
-> This Service Will Perform Create,Update  Operations On(updateSelectedTeam,UpdatInvitedTeam,updateAppliedTeam).
-> Method acceptedsp  updates SelectedTeamList, When IH accepts particular SP from applied list, delete SP from aplied users and updated to selected team list and if IH rejects, delete from applied team list
-> Method joinsp updates SelectedTeamList, When SP joins invited ideas. Delete SP from invited list and add him to selected team list