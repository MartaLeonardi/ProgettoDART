package Testing;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.TimerTask;

import GestioneStipendi.TempoControl;

public class MyTaskStipendio extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		TempoControl t = new TempoControl();
		LocalDate day = LocalDate.now();
		try {
			if(!(day.getDayOfMonth()==24)) {
				System.out.println("Niente query! Non e' il giorno giusto");
				return;
			}
			t.calcoloStipendio();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
