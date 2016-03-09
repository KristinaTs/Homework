package bg.ittalents.duper.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String DB_PASS = "ittstudent-123";
	private static final String DB_USER = "ittstudent";
	private static final String DB_NAME = "season5_java2";
	private static final String DB_PORT = "3306";
	private static final String DB_HOST = "192.168.8.22";

	private static DBConnection instance = null;
	private Connection con;

	private DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME, DB_USER,
					DB_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBConnection getInstance() {
		synchronized (DBConnection.class) {
			if (instance == null) {
				instance = new DBConnection();
			}
		}
		return instance;
	}

	public Connection getCon() {
		return con;
	}

}
