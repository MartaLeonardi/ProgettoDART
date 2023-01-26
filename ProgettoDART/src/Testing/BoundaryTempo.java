package Testing;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Timer;

public class BoundaryTempo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate d = LocalDate.now();
		MyTaskCalendario taskCalendario=new MyTaskCalendario();
		MyTaskStipendio taskStipendio=new MyTaskStipendio();
		MyTaskUscita taskUscita=new MyTaskUscita();
		Timer timer1=new Timer();
		System.out.print("Inizio \n");
		timer1.schedule(taskCalendario, Date.valueOf(d), 86400000);
		timer1.schedule(taskStipendio, Date.valueOf(d), 86400000);
		timer1.schedule(taskUscita, 900000);
	}

}
