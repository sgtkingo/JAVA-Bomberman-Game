package Core;


import java.util.Timer;
import java.util.TimerTask;

import Interface.EngineMask;

public class TimerEngine{
	EngineMask GameEngine;

	  Timer timer;
	  
	  public TimerEngine(EngineMask engine){
		GameEngine=engine;
	    timer = new Timer();
	    System.out.println("Timer ready...");
	  }

	  class RemindTask extends TimerTask {
	    public void run() {
	      System.out.println("Time's up!");
	      GameEngine.TikTak();
	    }
	  }
	  
	  public void clockWatch(int time) {
			    timer.schedule(new RemindTask(), time); 
	  }
	  
}
