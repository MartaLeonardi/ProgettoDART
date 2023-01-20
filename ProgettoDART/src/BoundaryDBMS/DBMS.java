package BoundaryDBMS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMS implements DbInterface {

	private static DBMS instance = null;
	
	public Connection connect;
	public PreparedStatement statement;
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
			
			//System.out.println("risultato query: " +rs);
			
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
	
	public void insertUtente(String matricola, String email, String nome, String cognome) {
		String sql = "INSERT into Utente(u_matricola, email, nome, cognome) value (?,?,?,?)";
		
		try {
			statement = connect.prepareStatement(sql);
			statement.setString(1, matricola);
			statement.setString(2, email);
			statement.setString(3, nome);
			statement.setString(4, cognome);
			
			statement.execute();
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void insertImpiegato(String matricola, String ruolo) {
		String sql2 = "insert into Impiegato (i_matricola, dataNascita, dataAssunzione, ruolo, oreLavorate, oreStraordinarie, oreFestive) value (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			statement = connect.prepareStatement(sql2);
			statement.setString(1, matricola);
			statement.setDate(2, Date.valueOf("2000-1-1"));
			statement.setDate(3, Date.valueOf("2022-1-1"));
			statement.setString(4, ruolo);
			statement.setInt(5, 0);
			statement.setInt(6, 0);
			statement.setInt(7, 0);
			
			statement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertAutenticazione(String matricola) {
		String sql3 = "insert into Autenticazione (ref_t_matricola, password) value (?,?)";
		
		try {
			statement = connect.prepareStatement(sql3);
			statement.setString(1, matricola);
			statement.setString(2, "1234");
			
			statement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void licenziaImpiegato(String matricola) {		
		String sql2 = "delete from Impiegato where i_matricola = ?";
		
		try {
			statement = connect.prepareStatement(sql2);			
			statement.setString(1, matricola);
			
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql3 = "delete from Autenticazione where ref_t_matricola = ?";
		
		try {
			statement = connect.prepareStatement(sql3);
			
			statement.setString(1, matricola);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql = "delete from Utente where u_matricola = ?";
		
		try {
			statement = connect.prepareStatement(sql);
			statement.setString(1,  matricola);
			
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
