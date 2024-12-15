package com.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dao.TeamDao;
import com.test.dto.ApiResponse;
import com.test.entities.Teams;
import com.test.service.TeamService;

@RestController
@RequestMapping("/teams")
public class HomeController {
	@Autowired
	private TeamService teamService;

	@GetMapping
	public ResponseEntity<?> getTeams() {
		System.out.println("get all");
		List<Teams> teams = teamService.getAllTeams();
		if (teams.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(teams);
	}

	@PostMapping
	public ResponseEntity<?> addNewTeam(@RequestBody Teams team) {
		System.out.println("in add team " + team);// transient category
		return ResponseEntity.status(HttpStatus.CREATED).body(teamService.addTeam(team));
	}

	@GetMapping("/{tId}")
	public ResponseEntity<?> getTeam(@PathVariable Long tId) {
		System.out.println("in get dtls " + tId);
		try {
			// invoke service layer method
			Teams team = teamService.getTeamDetails(tId);
			return ResponseEntity.ok(team);
		} catch (RuntimeException e) {
//			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PutMapping("/{tId}")
	public ResponseEntity<?> updateTeam(@PathVariable Long tId, @RequestBody Teams team) {
		System.out.println("in update Team " + tId + " " + team);

		// invoke service layer method
		// TO DO - change Sts code - in case of error !!!
		return ResponseEntity.ok(teamService.udateTeamDetails(tId, team));

	}

	@DeleteMapping("/{tId}")
	public ResponseEntity<?> deleteTeam(@PathVariable Long tId) {
		System.out.println("in get dtls " + tId);
		try {
			// invoke service layer method
			ApiResponse response = teamService.deleteTeam(tId);
			System.out.println(response);
			return ResponseEntity.ok(response);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

}
