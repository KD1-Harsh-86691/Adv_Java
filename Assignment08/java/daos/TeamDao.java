package com.cdac.daos;
import java.util.List;

import com.cdac.entities.Teams;


public interface TeamDao {
//add a method to register new team
	String signUpTeam(Teams teams);
// displaying all teams
	List<Teams> getAllTeams();
// display all teams acc to max age n batting avg
	List<Teams> getDisplayTeamsAccAgeAvg(int maxAge,double battingAvg);
// displaying owner name n abbrevations from battingavg and max avg
	List<Teams> getDisplayOwnerNameAndAbbreviation(int maxAge,double battingAvg);
// delete team by id
	String deleteTeam(Long userId);
// update max age 
	String updateMaxAge(String name , int age);
// Display team n player details
	Teams getTeamAndPlayerDetails(Long teamId);
// delete player from team
}
