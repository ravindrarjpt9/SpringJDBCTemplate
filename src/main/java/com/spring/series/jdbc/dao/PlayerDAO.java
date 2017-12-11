package com.spring.series.jdbc.dao;

import java.util.List;

import com.spring.series.jdbc.model.Player;

public interface PlayerDAO {

	// simple CRUD operations
	 public Player getPlayer(int playerId);
	    public String insertNewPlayer(Player player);
	    public List<Player> getAllPlayer();
	public int deletePlayerById(int id);
	public void insertPlayers(List<Player> list);
}
