package src.models.daos;
/**
 * 
 * @author Andrecio Costa / Dante Alighieri
 *
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import src.models.Logon;

public class LogonDAO extends Sql implements Dao<Logon> {
	public ArrayList<Logon> betweenDates(String start_time, String end_time) throws SQLException {
		this.openConnection();
		
		ArrayList<Logon> logons = new ArrayList<Logon>();
		String sql = "SELECT * FROM logon WHERE (date >= '" + start_time + "') AND (date <= '" + end_time + "');";

		PreparedStatement pst = null;
		ResultSet rs = null;

		pst = this.con.prepareStatement(sql);
		rs = pst.executeQuery();

		while (rs.next()) {
			logons.add(new Logon(rs.getInt("id"), rs.getString("logon_id"), rs.getString("date"),
					rs.getString("user_id"), rs.getString("pc_id"), rs.getString("activity")));
		}
		
		return logons;
	}
	
	public Logon get(String id) throws SQLException {
		this.openConnection();

		String sql = "SELECT * FROM logon WHERE id = " + id;
		
		System.out.println(sql);

		PreparedStatement pst = null;
		ResultSet rs = null;

		pst = this.con.prepareStatement(sql);
		rs = pst.executeQuery();

		Logon user = null;

		while (rs.next()) {
			user = new Logon(rs.getInt("id"), rs.getString("device_id"), rs.getString("date"), rs.getString("user_id"),
					rs.getString("pc_id"), rs.getString("activity"));
		}

		return user;
	}
	/** 
	 * Salva as atividades de logon no banco
	 * @param d
	 */
	public void save(Logon d) throws SQLException {
		this.openConnection();

		String sql = "SELECT * FROM http WHERE http_id = '" + d.getActivityId() + "'";
		
		System.out.println(sql);

		PreparedStatement pst = null;
		ResultSet rs = null;

		pst = this.con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		if (rs.next()) {
			sql = "UPDATE logon " + 
				  "SET logon_id = '" + d.getActivityId() + "', date = '" + d.getDate() +  "', user_id = '" + d.getUserId() + "', pc_id = '" + d.getPcId() + "', activity = '" + d.getActivity() + "' WHERE logon_id = '" + d.getActivityId() + "'";
		}
		else  {
			
			sql = "INSERT INTO logon " +
				  "(logon_id, date, user_id, pc_id, activity) VALUES " +
				  "('" + d.getActivityId() + "', '" + d.getDate() + "', '"+ d.getUserId() + "', '" + d.getPcId() + "', '" + d.getActivity() + "')";
		}
		
		System.out.println(sql);
		
		pst = this.con.prepareStatement(sql);
		pst.executeUpdate();
	}

	/** 
	 * Atualiza as atividades de logon no banco de acordo com os dados informado no parametrp params
	 * @param d, params
	 */
	public void update(Logon d, String[] params) {
		this.openConnection();
    }
    
	/** 
	 * Deleta as atividades de logon no banco
	 * @param d
	 */
    public void delete(Logon d) {
    	this.openConnection();
    }
}
