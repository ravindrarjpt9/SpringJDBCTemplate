package com.journaldev.spring.jdbc.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.series.jdbc.dao.PlayerDAO;
import com.spring.series.jdbc.model.Player;

public class TestPlayerInfo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"SpringContext.xml");
		
		PlayerDAO playerDAO = (PlayerDAO) ctx.getBean("playerDAO");
		System.out.println(" *********** get all player list ***************");
		List<Player> list = playerDAO.getAllPlayer();
		for(Player p : list){
			System.out.println("Id :"+p.getPlayerId() + " name : " + p.getName() + " age : " + p.getAge() + " Matches :" + p.getMatches() + "\n");
		}
		
		System.out.println("******** get first player ********** ");
		
		Player player = playerDAO.getPlayer(1);
		System.out.println(player.getName());
		
		//System.out.println("********* Insert new player ***********");
		//Player player2 = new Player();
		//player2.setPlayerId(11);
		//player2.setName("Ravindra Rajpoot");
		//player2.setAge(30);
		//player2.setMatches(12);
		//String status = playerDAO.insertNewPlayer(player2);
		//System.out.println(status);
		/*System.out.println("*********** delete seond player *************");
		int status = playerDAO.deletePlayerById(2);
		if(status == 1){
			System.out.println(" player deleted");
		}*/
		
		/*System.out.println(" *********** insert multipal palyer using batch*************");
		
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player(12, "abc", 12, 12));
		playerList.add(new Player(13, "err", 13, 13));
		playerList.add(new Player(14, "wdgfdf", 14, 14));
		playerList.add(new Player(15, "dkmdfmd", 15, 15));
		playerList.add(new Player(16, "lwndkdm", 16, 16));
		playerList.add(new Player(17, "wodjfjsd", 17, 17));
		playerDAO.insertPlayers(playerList);*/
		
	}
}
