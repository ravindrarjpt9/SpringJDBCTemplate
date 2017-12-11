package com.spring.series.jdbc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.series.jdbc.dao.PlayerDAO;
import com.spring.series.jdbc.model.Player;

@Repository("playerDAO")
public class PlayerDAOImpl implements PlayerDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate1;
 
	
	
	@Override
	public Player getPlayer(int playerId) {
		String sql = "select *  FROM PLAYER WHERE PLAYER_ID = ?";
		Player player = jdbcTemplate1.queryForObject(sql, new Object[]{playerId},new RowMapper<Player>() {
			
			@Override
			public Player mapRow(ResultSet rs, int arg1) throws SQLException {
				Player player = new Player();
				player.setAge(rs.getInt("AGE"));
				player.setMatches(rs.getInt("MATCHES"));
				player.setName(rs.getString("NAME"));
				player.setPlayerId(rs.getInt("PLAYER_ID"));
				return player;
			}
		});
		return player;
	}

	@Override
	public String insertNewPlayer(Player player) {
		String sql = "INSERT INTO PLAYER(PLAYER_ID,NAME, AGE, MATCHES) VALUES(?,?, ?, ?)";
		Object[] param = new Object[]{player.getPlayerId(),player.getName(),player.getAge(),player.getMatches()};
		int[] type = new int[]{Types.INTEGER,Types.VARCHAR,Types.INTEGER,Types.INTEGER};
		int retunrValue = jdbcTemplate1.update(sql, param);
		if(1 == retunrValue)
            return "Player creation is SUCCESS";
        else
            return "Player creation is FAILURE";
	}

	@Override
	public List<Player> getAllPlayer() {
		String sql = "SELECT PLAYER_ID, NAME, AGE, MATCHES FROM PLAYER";
		List<Player> list = jdbcTemplate1.query(sql,new RowMapper<Player>() {

			@Override
			public Player mapRow(ResultSet rs, int arg1) throws SQLException {
				
				Player player = new Player();
				player.setAge(rs.getInt("AGE"));
				player.setMatches(rs.getInt("MATCHES"));
				player.setName(rs.getString("NAME"));
				player.setPlayerId(rs.getInt("PLAYER_ID"));
				return player;
			}
			
		});
		return list;
	}

	
	@Override
	public int deletePlayerById(int id) {
		String sql = "delete from player where player_id=?";
		return jdbcTemplate1.update(sql, new Object[]{id});
	}

	@Override
	public void insertPlayers(List<Player> list) {
		String sql = "INSERT INTO PLAYER(PLAYER_ID,NAME, AGE, MATCHES) VALUES(?,?, ?, ?)";
		jdbcTemplate1.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Player p = list.get(i);
				ps.setInt(1, p.getPlayerId());
				ps.setString(2, p.getName());
				ps.setInt(3, p.getAge());
				ps.setInt(4, p.getMatches());
			}
			
			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
		
	}
	
}
