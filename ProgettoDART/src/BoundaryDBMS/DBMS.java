package BoundaryDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMS implements DbInterface {

	private static DBMS instance = null;
	
	private Connection connect;
	private PreparedStatement statement;
	private ResultSet rs;
	
	public DBMS() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	
	
	try {
		connect = DriverManager.getConnection("jdbc:mysql://"
				+ server + ":3306/" + database , user, password);
		System.out.println("DB CONNECTED!");
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	
	public synchronized DBMS getConnection() {
		if(instance==null)
			instance = new DBMS();
		return instance;
	}
	
	public ResultSet query(String sql) {
		try {
			statement=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return rs;
	}
	
	public void closeConnection() {
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
