package com.spring.series.jdbc.model;

public class Player {

	// local variables
    private int playerId;
    private String name;
    private int age;
    private int matches;
    
    public Player() {
		// TODO Auto-generated constructor stub
	}
    
	public Player(int playerId, String name, int age, int matches) {
		
		this.playerId = playerId;
		this.name = name;
		this.age = age;
		this.matches = matches;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
}
