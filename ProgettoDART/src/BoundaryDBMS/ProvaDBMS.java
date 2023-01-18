package BoundaryDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProvaDBMS implements DbInterface {

	private static ProvaDBMS instance = null;
	
	private Connection connect;
	private PreparedStatement statement;
	private ResultSet rs;
	
	public ProvaDBMS() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
	try {
		connect = DriverManager.getConnection("jdbc:mysql://"
				+ server + ":3306/" + database , user, password);
		System.out.println("DB CONNECTED!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	public synchronized ProvaDBMS getConnection() {
		if(instance==null)
			instance = new ProvaDBMS();
		return instance;
	}
	
	public ResultSet query(String sql) {
		try {
			statement=connect.prepareStatement(sql);
			rs=statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return rs;
	}

}
