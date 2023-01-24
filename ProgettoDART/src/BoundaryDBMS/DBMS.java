package BoundaryDBMS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import GestioneStipendi.Impiegati;
import java.time.LocalTime;


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

	public void setStato(LocalDate data, String servizio, int turno, boolean presenza) {
		
		String sql = "insert into Stato (giornata_lavoro, ref_servizio, turno_orari, presenza) value (?,?,?,?)";
		
		try {
			statement = connect.prepareStatement(sql);
			
			statement.setDate(1, Date.valueOf(data.toString()));
			statement.setString(2, servizio);
			statement.setInt(3, turno);
			statement.setBoolean(4, presenza);
			
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
            statement.setDate(1, Date.valueOf(data));
            statement.setString(2, servizio);
            statement.setString(3, fasciaOraria);
            statement.setString(4, matricola);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            }
    }

	public void deleteTuplaImp(String matricola, String dInizio, String dFine) {
		
	       String sql3 = "DELETE FROM Turno WHERE giornata_lavoro >=? AND giornata_lavoro<=? AND ref_i_matricola=?";

	        try {
	            statement = connect.prepareStatement(sql3);
	            statement.setDate(1, Date.valueOf(dInizio));
	            statement.setDate(2, Date.valueOf(dFine));
	            statement.setString(3, matricola);
	            statement.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e);
	            }
		
	} 
	
	public void updateStato(String giorno, String servizio, String fascia) {
		
		String sql = "update Stato set presenza = 0 where giornata_lavoro = ? AND ref_servizio=? AND turno_orari=?";
		
		try {
			statement = connect.prepareStatement(sql);
			statement.setString(1, giorno);
			statement.setString(2, servizio);
			statement.setString(3, fascia);
			
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void removeTurni(String date) {
		
		String sql = "delete from Turno where giornata_lavoro <= ?";
		
		try {
			statement = connect.prepareStatement(sql);
			statement.setString(1, date);
			
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateEntrata(String matricola, String date) {
		
		String sql = "update Turno set entrata = true where ref_i_matricola = ?  and giornata_lavoro = ?";
		
		try {
			statement = connect.prepareStatement(sql);
			statement.setString(1, matricola);
			statement.setDate(2, Date.valueOf(date));
			
			statement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateUscita(String matricola, String date) {
		
		String sql = "update Turno set uscita = true where ref_i_matricola = ?  and giornata_lavoro = ?";
		
		try {
			statement = connect.prepareStatement(sql);
			statement.setString(1, matricola);
			statement.setDate(2, Date.valueOf(date));
			
			statement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertRitardo(String matricola, String date) {
		
		String sql = "insert into Ritardo (ref_matricola_r, giorno) value (?,?)";
		
		try {
			statement = connect.prepareStatement(sql);
			statement.setString(1, matricola);
			statement.setDate(2, Date.valueOf(date));
			
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updateOre(int oreLavorate, int oreStraordinarie, int oreFestive, String matricola) {
		
		String sql = "update Impiegato set oreLavorate = ?, oreStraordinarie = ?, oreFestive = ? where i_matricola = ?";
		
		try {
			statement = connect.prepareStatement(sql);
			statement.setInt(1, oreLavorate);
			statement.setInt(2, oreStraordinarie);
			statement.setInt(3, oreFestive);
			statement.setString(4, matricola);
			
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updateUscitaAuto(LocalDate data, LocalTime tempo) {
		
		String sql = ("update Turno set uscita = true where giornata_lavoro = ?  and "
				+ "	fine_turno <= ? and ? > ? and entrata = true and uscita is null");
		LocalTime tempoSomma = tempo.plusMinutes(5);
		System.out.println(tempoSomma.toString());
		try {
			statement = connect.prepareStatement(sql);
			statement.setDate(1, Date.valueOf(data.toString()));
			statement.setTime(2, Time.valueOf(tempo.toString()+":00"));
			statement.setTime(3, Time.valueOf(tempoSomma.toString()+":00"));
			statement.setTime(4, Time.valueOf(tempo.toString()+":00"));
			
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public ArrayList<String> retriveImpiegato() {
		String sql3 = "SELECT i_matricola FROM Impiegato";
		String m;
		ArrayList<String> matricola = new ArrayList<String>();
		try {
			statement = connect.prepareStatement(sql3);
			while(rs.next()) {
				m = rs.getString("i_matricola");
				matricola.add(new String(m));
			}
			return matricola;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			return null;
			}
	}
	
	public ArrayList<Impiegati> retriveImpiegatoByRole(String ruolo) {
		String sql3 = "SELECT * FROM Impiegato WHERE ruolo = '"+ruolo+"'";
		String matricola;
		ArrayList<Impiegati> imp = new ArrayList<Impiegati>();
		try {
			rs=query(sql3);
			while(rs.next()) {
				matricola = rs.getString("i_matricola");
				imp.add(new Impiegati(matricola, ruolo));
			}
			return imp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
	public void insertTurno(String matricola, String giornata, String iTurno, String fTurno, int fascia, String servizio) {
		String sql3 = "INSERT INTO Turno (ref_i_matricola, giornata_lavoro, inizio_turno, fine_turno, fascia_oraria, servizio) values(?, ?, ?, ?, ?, ?)";
		
		try {
			statement = connect.prepareStatement(sql3);
			statement.setString(1, matricola);
			statement.setDate(2, Date.valueOf(giornata));
			statement.setTime(3, Time.valueOf(iTurno));
			statement.setTime(4, Time.valueOf(fTurno));
			statement.setInt(5, fascia);
			statement.setString(6, servizio);
			statement.execute();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			}
		}
	
	public ArrayList<String> retriveImpiegatoForTurnoForFascia(LocalDate data, int fascia) {
		String sql3 = "SELECT ref_i_matricola FROM Turno WHERE giornata_lavoro = '"+data.toString()+"'"+" fascia='"+fascia+"'";
		String m;
		ArrayList<String> matricola = new ArrayList<String>();
		try {
			rs = query(sql3);
			while(rs.next()) {
				m = rs.getString("ref_i_matricola");
				matricola.add(new String(m));
			}
			return matricola;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			return null;
			}
	}
	
	public ArrayList<String> retriveImpiegatoForTurno(LocalDate data) {
		String sql3 = "SELECT ref_i_matricola FROM Turno WHERE giornata_lavoro = '"+data.toString()+"'";
		String m;
		ArrayList<String> matricola = new ArrayList<String>();
		try {
			rs = query(sql3);
			while(rs.next()) {
				m = rs.getString("ref_i_matricola");
				matricola.add(new String(m));
			}
			return matricola;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			return null;
			}
	}
	
	public ArrayList<String> retriveImpiegatoFromRichiestaForGiorno(LocalDate data) {
		String sql3 = "SELECT ref_matricola FROM Richiesta WHERE giornata_lavoro = '"+data.toString()+"'";
		String m;
		ArrayList<String> matricola = new ArrayList<String>();
		try {
			rs = query(sql3);
			while(rs.next()) {
				m = rs.getString("ref_matricola");
				matricola.add(new String(m));
			}
			return matricola;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			return null;
			}
	}
		
	public void updateOre(String matricola, String data, String oraI, String oraF) {
		
		String sql ="UPDATE Turno set inizio_turno=?, fine_turno=? WHERE ref_i_matricola=? AND giornata_lavoro=?";
		
		try {
			statement = connect.prepareStatement(sql);
			statement.setTime(1, Time.valueOf(oraI));
			statement.setTime(2, Time.valueOf(oraF));
			statement.setString(3, matricola);
			statement.setDate(4, Date.valueOf(data));
			
			statement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateEmail(String matricola, String email) {
		
		String sql = "update Utente set email = ? where u_matricola = ?";
		
		try {
			statement = connect.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, matricola);
			
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

	
