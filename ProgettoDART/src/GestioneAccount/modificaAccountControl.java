package GestioneAccount;
import PopUp.OKPopUp;
import PopUp.OkCancelPopUp;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class modificaAccountControl {
	
	/*
	 * Controllo della stringa mail inserita
	 * pattern mail = Stringa dove sono concessi numeri e lettere(minuscole e maiuscole) + @ + dominio
	 * il dominio è composto da: stringa lettere e numeri + . + stringa sole lettere
	 * 
	 * il metodo restituisce un valore booleano true se la mail soddisfa tutti i requisiti del pattern
	 * false se non li soddisfa
	 */
	public static boolean checkMail (String email) {
		
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(email);

		boolean matchFound = m.matches();

		StringTokenizer st = new StringTokenizer(email, ".");
		String lastToken = null;
		while (st.hasMoreTokens()) {
			lastToken = st.nextToken();
			}

		if (matchFound && lastToken.length() >= 2 && email.length() - 1 != lastToken.length()) {
			return true;
		}
		else
		{
			return false;
		}
}
	
	
}
