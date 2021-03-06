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

import src.models.Device;

public class DeviceDAO extends Sql implements Dao<Device> {
	public ArrayList<Device> betweenDates(String start_time, String end_time) throws SQLException {
		this.openConnection();
		
		ArrayList<Device> devices = new ArrayList<Device>();
		String sql = "SELECT * FROM devices WHERE (date >= '" + start_time + "') AND (date <= '" + end_time + "');";

		PreparedStatement pst = null;
		ResultSet rs = null;

		System.out.println(sql);
		pst = this.con.prepareStatement(sql);
		rs = pst.executeQuery();

		while (rs.next()) {
			devices.add(new Device(rs.getInt("id"), rs.getString("device_id"), rs.getString("date"),
					rs.getString("user_id"), rs.getString("pc_id"), rs.getString("activity")));
		}
		
		return devices;
	}
	
	public Device get(String id) throws SQLException {
		this.openConnection();

		String sql = "SELECT * FROM devices WHERE id = " + id;
		
		System.out.println(sql);

		PreparedStatement pst = null;
		ResultSet rs = null;

		pst = this.con.prepareStatement(sql);
		rs = pst.executeQuery();

		Device user = null;

		while (rs.next()) {
			user = new Device(rs.getInt("id"), rs.getString("device_id"), rs.getString("date"), rs.getString("user_id"),
					rs.getString("pc_id"), rs.getString("activity"));
		}

		return user;
	}
	/** 
	 * Salva as atividades de device no banco
	 * @param d
	 */
	public void save(Device d) throws SQLException {
		this.openConnection();

		String sql = "SELECT * FROM devices WHERE device_id = '" + d.getActivityId() + "'";
		
		System.out.println(sql);

		PreparedStatement pst = null;
		ResultSet rs = null;

		pst = this.con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		if (rs.next()) {
			sql = "UPDATE devices " + 
				  "SET device_id = '" + d.getActivityId() + "', date = '" + d.getDate() +  "', user_id = '" + d.getUserId() + "', pc_id = '" + d.getPcId() + "', activity = '" + d.getActivity() + "' WHERE device_id = '" + d.getActivityId() + "'";
		}
		else  {
			
			sql = "INSERT INTO devices " +
				  "(device_id, date, user_id, pc_id, activity) VALUES " +
				  "('" + d.getActivityId() + "', '" + d.getDate() + "', '"+ d.getUserId() + "', '" + d.getPcId() + "', '" + d.getActivity() + "')";
		}
		
		System.out.println(sql);
		
		pst = this.con.prepareStatement(sql);
		pst.executeUpdate();
	}

	/** 
	 * Atualiza as atividades de device no banco de acordo com os dados informado no parametrp params
	 * @param d, params
	 */
	public void update(Device d, String[] params) {
		this.openConnection();
    }
    
	/** 
	 * Deleta as atividades de device no banco
	 * @param d
	 */
    public void delete(Device d) {
    	this.openConnection();
    }
}
