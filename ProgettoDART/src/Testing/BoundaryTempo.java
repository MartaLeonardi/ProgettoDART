package Testing;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Timer;

public class BoundaryTempo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate d = LocalDate.now(); 
		//LocalDate d = LocalDate.of(2023/01/25);
		MyTaskCalendario taskCalendario=new MyTaskCalendario();
		MyTaskStipendio taskStipendio=new MyTaskStipendio();
		MyTaskUscita taskUscita=new MyTaskUscita();
		Timer timer1=new Timer();
		Timer timer2=new Timer();
		Timer timer3=new Timer();
		System.out.print("Inizio \n");
		timer1.schedule(taskCalendario, Date.valueOf(d), 86400000);
		timer2.schedule(taskStipendio, Date.valueOf(d), 86400000);
		timer3.schedule(taskUscita,Date.valueOf(d), 60000);
	}

}
