package com.cdac.entities;

import javax.persistence.*;

@Entity
@Table(name = "ipl_teams")
public class Teams {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private Long teamId;
	@Column(length = 100)
	private String name;
	@Column(length = 10, unique = true)
	private String abbreviation;
	@Column(length = 20)
	private String owner;
	@Column(name = "max_player_age")
	private int maxPlayerAge;
	@Column(name = "batting_avg")
	private double battingAvg;
	@Column(name = "wickets_taken")
	private int wicketsTaken;

	public Teams() {
	}

	
	public Teams(String abbreviation, String owner) {
		this.abbreviation = abbreviation;
		this.owner = owner;
	}


	public Teams(String name, String abbreviation, String owner, int maxPlayerAge, double battingAvg,
			int wicketsTaken) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxPlayerAge() {
		return maxPlayerAge;
	}

	public void setMaxPlayerAge(int maxPlayerAge) {
		this.maxPlayerAge = maxPlayerAge;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxPlayerAge=" + maxPlayerAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken
				+ "]";
	}

}
