package src.models.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.models.Http;

public class HttpDAO extends Sql implements Dao<Http> {
	public Http get(String id) throws SQLException {
		this.openConnection();

		String sql = "SELECT * FROM http WHERE id = " + id;
		
		System.out.println(sql);

		PreparedStatement pst = null;
		ResultSet rs = null;

		pst = this.con.prepareStatement(sql);
		rs = pst.executeQuery();

		Http user = null;

		while (rs.next()) {
			user = new Http(rs.getInt("id"), rs.getString("device_id"), rs.getString("date"), rs.getString("user_id"),
					rs.getString("pc_id"), rs.getString("activity"));
		}

		return user;
	}

	public void save(Http d) throws SQLException {
		this.openConnection();

		String sql = "SELECT * FROM http WHERE http_id = '" + d.getActivityId() + "'";
		
		System.out.println(sql);

		PreparedStatement pst = null;
		ResultSet rs = null;

		pst = this.con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		if (rs.next()) {
			sql = "UPDATE http " + 
				  "SET http_id = '" + d.getActivityId() + "', date = '" + d.getDate() +  "', user_id = '" + d.getUserId() + "', pc_id = '" + d.getPcId() + "', activity = '" + d.getActivity() + "' WHERE http_id = '" + d.getActivityId() + "'";
		}
		else  {
			
			sql = "INSERT INTO http " +
				  "(http_id, date, user_id, pc_id, activity) VALUES " +
				  "('" + d.getActivityId() + "', '" + d.getDate() + "', '"+ d.getUserId() + "', '" + d.getPcId() + "', '" + d.getActivity() + "')";
		}
		
		System.out.println(sql);
		
		pst = this.con.prepareStatement(sql);
		pst.executeUpdate();
	}

	public void update(Http d, String[] params) {
		this.openConnection();
    }
     
    public void delete(Http d) {
    	this.openConnection();
    }
}
