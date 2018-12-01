package src.models.daos;

import src.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author Andrécio Costa / Dante Alighieri
 *
 */
public class UserDAO extends Sql implements Dao<User> {
	
	public User get(String id) throws SQLException {
		this.openConnection();
		
		String sql = "SELECT * FROM users WHERE id = " + id;
		
		PreparedStatement pst = null; 
		ResultSet rs = null;
		
		pst = this.con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		User user = null;
		
		while(rs.next()){
			user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("user_id"), rs.getString("role"));
		}
		
		return user;
	}
	
    public void save(User u) {
		this.openConnection();
    }
     
	public void update(User u, String[] params) {
		this.openConnection();
    }
     
    public void delete(User u) {
    	this.openConnection();
    }
    
 }
