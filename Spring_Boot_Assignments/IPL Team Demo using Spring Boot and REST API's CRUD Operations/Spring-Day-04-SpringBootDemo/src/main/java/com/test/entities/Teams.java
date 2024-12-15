package com.test.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString(callSuper = true, exclude = { "players" })
@NoArgsConstructor

public class Teams extends BaseEntity {

	@Column(name = "team_name", length = 100, unique = true)
	private String teamName;

	@Column(name = "team_abbreviation", length = 15, unique = true)
	private String abbreviation;

	@Column(name = "owner", length = 20, nullable = false)
	private String owner;

	@Column(name = "max_player_age ")
	private int maxPlayerAge;

	@Column(name = "batting_avg")
	private double battingAvg;

	@Column(name = "wickets_taken")
	private int wicketTaken;

}
