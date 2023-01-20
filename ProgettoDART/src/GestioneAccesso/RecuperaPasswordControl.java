package GestioneAccesso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import BoundaryDBMS.DBMS;
import PopUp.OKPopUp;

public class RecuperaPasswordControl {
	
	public  RecuperaPasswordControl(String matricola){
		if(checkMatricola(matricola)) {
			String newPass = generatePassword(4);
			
			DBMS db = new DBMS();
		
			db.updatePassword(matricola, newPass);
			
			db.closeConnection();
				
			OKPopUp popUp = new OKPopUp("La nuova password e' " + newPass);
			popUp.setVisible(true);
			System.out.println(newPass);
		}
		else {
			OKPopUp popUP = new OKPopUp("Matricola non valida");
			popUP.setVisible(true);
		}
	}
				
	
	public boolean checkMatricola(String matricola) {
		if(matricola.equals("")) {
			return false;
		}
	
		if(!(Integer.parseInt(matricola) > 0)) {
			return false;
		}
		if(matricola.length() > 5 || matricola.length() < 5) {
			return false;
		}
		
		if (!(matricola.substring(0, 1).equals("0"))) {
			return false;
		}
		
		DBMS db = new DBMS();
		String sql = "select u_matricola from Utente where u_matricola = '" + matricola + "'";
		
		ResultSet rs = db.query(sql);
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		db.closeConnection();
	
	return false;
	}
	
	 private static String generatePassword(int length) {
	      String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[length];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< length ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      return String.valueOf(password);
	   }

}
