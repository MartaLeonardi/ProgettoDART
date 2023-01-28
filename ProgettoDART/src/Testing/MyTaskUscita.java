package Testing;

import java.time.LocalTime;
import java.util.TimerTask;

import RilevazionePresenze.UscitaAutomaticaControl;

public class MyTaskUscita extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		UscitaAutomaticaControl uac = new UscitaAutomaticaControl();
		LocalTime time = LocalTime.now();
		if(((LocalTime.now().getHour()%2)==0 && LocalTime.now().getMinute()==15)) {
			System.out.println("Uscita calcolata");
			uac.uscitaAuto();
		} else {System.out.println("Uscita non calcolata");}
	}

}