package Login;

import PortaleAmministratore.PortaleAmministratore;
import PortaleImpiegato.PortaleImpiegato;

public class LoginControl {
	
	public static void main (String[] args) {
			String matricola = LoginJFrame.getMatricola();

			
			if(check(matricola)) {
				System.out.println("true");
				choosePortal(matricola);
			}
			
			
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
}
