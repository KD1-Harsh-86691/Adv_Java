package com.cdac.daos;

import com.cdac.entities.Player;

public interface PlayerDao {
//	Add Player to the team
	String addNewPlayer(Long teamId, Player Player);
// Delete player from team
	String deletePlayerFromTeam(long nextLong, long nextLong2);
}
