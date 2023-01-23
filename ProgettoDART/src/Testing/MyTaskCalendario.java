package Testing;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.TimerTask;

import GestioneStipendi.TempoControl;

public class MyTaskCalendario extends TimerTask{
	public void run() {
		// TODO Auto-generated method stub
		TempoControl t = new TempoControl();
		LocalDate day = LocalDate.now();
		try {
			t.calcoloCalendario(day, day.plusMonths(3).plusDays(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
