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
	
	public void insertImpiegato(String matricola, String ruolo, String telefono) {
		String sql2 = "insert into Impiegato (i_matricola, telefono, ruolo, oreLavorate, oreStraordinarie, oreFestive) value (?, ?, ?, ?, ?, ?)";
		
		try {
			statement = connect.prepareStatement(sql2);
			statement.setString(1, matricola);
			//statement.setDate(2, Date.valueOf("2000-1-1"));
			//statement.setDate(3, Date.valueOf("2022-1-1"));
			statement.setString(2, telefono);
			statement.setString(3, ruolo);
			statement.setInt(4, 0);
			statement.setInt(5, 0);
			statement.setInt(6, 0);
			
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

	public void insertRichiesta(String matricola, String motivazione, String dInizio, String dFine, int oraInizio,
			int oraFine, boolean check) {
		String sql3 = "insert into Richiesta (ref_matricola, tipo, data_inizio, ora_inizio, data_fine, ora_fine, giornata_completa) value ( ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			statement = connect.prepareStatement(sql3);
			statement.setString(1, matricola);
			statement.setString(2, motivazione);
			statement.setDate(3, Date.valueOf(dInizio));
			statement.setInt(4, oraInizio);
			statement.setDate(5, Date.valueOf(dFine));
			statement.setInt(6, oraFine);
			statement.setBoolean(7, check);
			statement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updatePassword(String matricola, String password) {
		
		String sql = "update Autenticazione set password = ? where ref_t_matricola = ?";
		
		try {
			statement = connect.prepareStatement(sql);
			statement.setString(1, password);
			statement.setString(2, matricola);
			
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertStipendi(String matricola, String date, int stipendio) {
		
		String sql = "insert into Stipendio (ref_S_matricola, dataPagamento, valoreStipendio) value (?,?,?)";
		
		try {
			statement = connect.prepareStatement(sql);
			statement.setString(1, matricola);
			statement.setDate(2, Date.valueOf(date));
			statement.setInt(3, stipendio);
			
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updateOreStipendi(String matricola) {
		
		String sql = "update Impiegato set oreLavorate = 0, oreStraordinarie = 0, oreFestive = 0 where ref_S_matricola = '" + matricola + "'";
		
		try {
			statement = connect.prepareStatement(sql);
			
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void deleteTuplaImp(String matricola, String data, String servizio, String fasciaOraria) {
        String sql3 = "DELETE FROM Turno WHERE giornata_lavoro = ? AND servizio=? AND fascia_oraria=? AND ref_i_matricola=?";

        try {
            statement = connect.prepareStatement(sql3);
            statement.setString(1, matricola);
            statement.setDate(2, Date.valueOf(data));
            statement.setString(3, servizio);
            statement.setString(4, fasciaOraria);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            }
    } 

}
