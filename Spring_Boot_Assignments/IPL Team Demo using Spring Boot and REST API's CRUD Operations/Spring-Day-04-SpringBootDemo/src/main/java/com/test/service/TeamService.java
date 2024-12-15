package com.test.service;

import java.util.List;

import com.test.dto.ApiResponse;
import com.test.entities.Teams;

public interface TeamService {

	public List<Teams> getAllTeams();

	public String addTeam(Teams team);

	Teams getTeamDetails(Long id);

	ApiResponse udateTeamDetails(Long teamId, Teams team);
	ApiResponse deleteTeam(Long teamId);

}
