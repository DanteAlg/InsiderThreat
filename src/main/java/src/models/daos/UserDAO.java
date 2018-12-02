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
	public User getByUserId(String id) throws SQLException {
		this.openConnection();

		String sql = "SELECT * FROM users WHERE user_id = " + id;
		
		System.out.println(sql);

		PreparedStatement pst = null;
		ResultSet rs = null;

		pst = this.con.prepareStatement(sql);
		rs = pst.executeQuery();

		User user = null;

		while (rs.next()) {
			user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("user_id"),
					rs.getString("role"));
		}

		return user;
	}

	public User get(String id) throws SQLException {
		this.openConnection();

		String sql = "SELECT * FROM users WHERE id = " + id;
		
		System.out.println(sql);

		PreparedStatement pst = null;
		ResultSet rs = null;

		pst = this.con.prepareStatement(sql);
		rs = pst.executeQuery();

		User user = null;

		while (rs.next()) {
			user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("user_id"),
					rs.getString("role"));
		}

		return user;
	}

	/** 
	 * Salva os usuarios no banco
	 * @param d
	 */
	public void save(User u) throws SQLException {
		this.openConnection();

		String sql = "SELECT * FROM users WHERE user_id = '" + u.getUserId() + "'";
		
		System.out.println(sql);

		PreparedStatement pst = null;
		ResultSet rs = null;

		pst = this.con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		if (rs.next()) {
			sql = "UPDATE users " + 
				  "SET name = '" + u.getName() + "', email = '" + u.getEmail() +  "', role = '" + u.getRole() + "' WHERE user_id = '" + u.getUserId() + "'";
		}
		else  {
			
			sql = "INSERT INTO users " +
				  "(name, email, role, user_id) VALUES " +
				  "('" + u.getName() + "', '" + u.getEmail() + "', '"+ u.getEmail() + "', '" + u.getUserId() + "')";
		}
		
		System.out.println(sql);
		
		pst = this.con.prepareStatement(sql);
		pst.executeUpdate();
	}

	/** 
	 * Atualiza as atividades de logon no banco de acordo com os dados informado no parametrp params
	 * @param d, params
	 */
	public void update(User u, String[] params) {
		this.openConnection();
    }
    
	/** 
	 * Deleta usuarios no banco
	 * @param d
	 */
    public void delete(User u) {
    	this.openConnection();
    }
}
