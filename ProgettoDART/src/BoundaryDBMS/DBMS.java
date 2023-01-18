package BoundaryDBMS;
import java.sql.*;

public class DBMS {
	private static DBMS instance;
	public Statement stat;
	private Connection con;
	
	public DBMS() {}
	public static DBMS getIstance() {
		if(instance == null) {
			instance = new DBMS();
		}
		return instance;
	}
	
	public void prova() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com/sql11590906", "sql11590906", "QIUpTZeWKm");
			Statement stat = con.createStatement();
			//System.out.println("inserting records");
			//String sql2 = "Insert into Servizio values(?, ?)";
			//String sql = "DELETE FROM Servizio WHERE nomeServizio=\"scarico\" AND maggiorazione=12";
			//stat.executeUpdate(sql);
			//PreparedStatement stmt = con.prepareStatement(sql2);
			/*stmt.setString(1, "scarico");
			stmt.setInt(2, 12);
			stmt.executeUpdate();*/
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

