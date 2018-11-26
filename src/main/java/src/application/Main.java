package src.application;

import java.sql.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
	public static String url = "jdbc:postgresql://localhost/inside_threat";
	
	private static Connection con;
	
	public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("properties/database.properties");
        props.load(file);
        return props;
    }
	
	public static void main(String args[]) throws IOException {
		Properties prop = getProp();
		 
		String db_user = prop.getProperty("db.username");
		String db_password = prop.getProperty("db.password");
		System.out.printf("Usuário: " + db_user);
		System.out.printf("\nPassword: " + db_password);
	}
	
	public static Connection getConnection() {
		return con;
	}
}
