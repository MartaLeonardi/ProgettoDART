package GestionePersonale;

import java.sql.ResultSet;
import java.sql.SQLException;

import BoundaryDBMS.DBMS;

public class AddEmpControl {
	
	private String matricola;
	private String nome;
	private String cognome;
	private String email;
	private String telefono;
	private String ruolo;
	private String stipendio;

	public AddEmpControl(String nome, String cognome, String matricola, String email, String telefono, String ruolo, String stipendio) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.ruolo = ruolo;
		this.stipendio = stipendio;
		
		if(checkMatricola(matricola)) {
			
		}
		else {
			
		}
		
		
		
		
	}
	
	public boolean checkMatricola(String matricola) {
		try {
			if(Integer.parseInt(matricola) > 0) {
				DBMS database = new DBMS();
				
				String sql = "SELECT u_matricola  FROM Utente WHERE u_matricola = '" + matricola + "'";
				
				try {
					ResultSet rs=database.query(sql);
					rs.first();
					do {
						String row =rs.getString("ref_t_matricola");
						//System.out.println(row);
						database.closeConnection();
						if(row.equals("")) {
							return true;
						}
						else {
							return false;
						}
					}while(rs.next());
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
				
				
			}
			}
			catch(Exception e) {
				return false;
			}
			return false;
		}
		
}
