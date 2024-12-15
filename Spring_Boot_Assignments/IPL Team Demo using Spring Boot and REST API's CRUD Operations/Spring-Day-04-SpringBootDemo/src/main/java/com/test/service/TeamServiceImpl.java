package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.TeamDao;
import com.test.dto.ApiResponse;
import com.test.entities.Teams;
import com.test.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamDao teamDao;
	
	@Override
	public List<Teams> getAllTeams() {
		// TODO Auto-generated method stub
		return teamDao.findAll();
	}

	@Override
	public String addTeam(Teams team) {
		Teams persistTeam = teamDao.save(team);
		return "Added new team with ID="+persistTeam.getId();
	}
	
	@Override
	public  Teams getTeamDetails(Long id){
		Teams team = teamDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid team ID!!!"));
		return team;
	}
	

	@Override
	@Transactional
	public ApiResponse udateTeamDetails(Long teamId, Teams team) {
		
		 if (teamId == null || team == null) {
		        return new ApiResponse("Team ID or team details cannot be null");
		    }

		    // Check if the team with the given ID exists
		    if (teamDao.existsById(teamId)) {
		        // Ensure the team object has the correct team ID
		        team.setId(teamId);
		        teamDao.save(team); // saveOrUpdate is internally handled by JPA repositories
		        return new ApiResponse("Team updated successfully.");
		    }

		    // Return an error response if the team ID does not exist
		    return new ApiResponse("Invalid Team ID");
	}

	
	@Override
	public ApiResponse deleteTeam(Long teamId) {
		System.out.println("delete team id...");
		if(teamDao.existsById(teamId)) {
			teamDao.deleteById(teamId);
			
			return new ApiResponse("team delete successfully.. with id = " + teamId); 
		}
		
		return  new ApiResponse("Invalid Team Id");
	}
	

}
