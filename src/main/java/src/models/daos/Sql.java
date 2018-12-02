package src.models.daos;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.*;

import java.util.Properties;
/**
 * 
 * @author Andrécio Costa / Dante Alighieri
 *
 */
public class Sql {
	public String dbUrl = "jdbc:postgresql://localhost/inside_threat";
	protected Connection con;

	/**
	 * Abre a conexão com o banco
	 */
	protected void openConnection() {
		if (con != null) return;
		
		Properties prop = getProp();
		
		String db_user = prop.getProperty("db.username");
		String db_password = prop.getProperty("db.password");
		
		if (db_user == null || db_password == null)
			System.out.println("Missing database keys! Fill your properties variables.");
		
		try 
		{
			con = DriverManager.getConnection(dbUrl, db_user, db_password);
			connectLog();
		}
		catch (Exception except) {
			System.out.println("Error Establishing Connection: " + except.getMessage());
		}
	}
	
	private void connectLog() throws SQLException {
		DatabaseMetaData dbmd = con.getMetaData();
		
		System.out.println("\nConnected with " +
				dbmd.getDriverName() + " " + dbmd.getDriverVersion()
				+ "{ " + dbmd.getDriverMajorVersion() + "," +
				dbmd.getDriverMinorVersion() + " }" + " to " +
				dbmd.getDatabaseProductName() + " " +
				dbmd.getDatabaseProductVersion() + "\n");
	}

	// Get environment properties to start database
	protected Properties getProp() {
		Properties props = new Properties();
		
		try 
		{
			FileInputStream file = new FileInputStream("properties/database.properties");
			props.load(file);	
		}
		catch (IOException e) {
			System.out.println("Configure your database.properties");
		}
		
		return props;
	}
}
