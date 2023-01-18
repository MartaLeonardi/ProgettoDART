package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BoundaryDBMS.DBMS;
import BoundaryDBMS.ProvaDBMS;
import PortaleAmministratore.PortaleAmministratore;
import PortaleImpiegato.PortaleImpiegato;

public class LoginControl {
	
	public static void main (String[] args) {
			String matricola = Login.getMatricola();

			controllo(matricola);
			
			
			/*if(check(matricola)) {
				
				if(checkSql(matricola)) {;
				
				System.out.println("true");
				choosePortal(matricola);
				}									//commentato da Marta per prova db
				
				
				
			}*/
			
			
	}
	
	
	
	public static boolean check(String matricola) {
		try {
		if(Integer.parseInt(matricola) > 0) {
			return true;
		}
		}
		catch(Exception e) {
			return false;
		}
		return false;
	}
	
	
	public static void choosePortal(String matricola) {
		if (matricola.equals(null)) {
			System.out.println("x");
		} else if (matricola.substring(0, 1).equals("0")) {
			PortaleImpiegato portaleImp = new PortaleImpiegato();
			portaleImp.setVisible(true);
		} else if (matricola.substring(0, 1).equals("1")) {
			PortaleAmministratore portaleAmm = new PortaleAmministratore();
			portaleAmm.setVisible(true);
			
		}
	}
	
	
	/*public static boolean checkSql(String matricola) {
		try {
			//System.out.println("test");
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com/sql11590906", "sql11590906", "QIUpTZeWKm");
			//Statement stat = con.createStatement();
			DBMS db = new DBMS();
			db.prova();
			System.out.println("inserting records");
			String sql = "select u_matricola FROM Utente WHERE u_matricola = '" + matricola + "';";
			ResultSet rs = db.stat.executeQuery(sql);
			//int result = stat.executeUpdate(sql);
			String result = "";
			rs.first();
			while (rs.next())
		      {
		       result = rs.getString("u_matricola");
		      }
			if(result.equals(matricola)) {
				System.out.println("true");
				return true;
			}
			else {
				return false;
			}

		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}*/
	
	
	//METODO AGGIUNTO DA MARTA PER PROVA COLLEGAMENTO DB
	public static void controllo (String matricola) {
		
		ProvaDBMS database = new ProvaDBMS();
		
		String sql = "select u_matricola FROM Utente WHERE u_matricola =" + matricola ;
	
		try {
			ResultSet rs=database.query(sql);
			rs.first();
			do {
				String row =rs.getString("u_matricola");
				System.out.println(row);
			}while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fine controllo");
		
		
		
	}
	
}
