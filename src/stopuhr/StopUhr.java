package stopuhr;

import kopfrechnen2.OutputPanel;

public class StopUhr extends Thread {

    OutputPanel op;
	public long time;
	public long startTime;
	public long currentTime;
	 
	public StopUhr(OutputPanel op) {
	 this.op = op;
		time = 0;
	  
	}
 
	public float getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
 
	@Override
	public void run() {
		startTime = System.nanoTime()/1000000000;
		//startTime = System.currentTimeMillis()/1000;
		 while(!this.isInterrupted()) {
			  
			 try {
				  
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				 
				this.interrupt();
				System.out.println("Der Thread ist unterbrochen!");
				 
			}
			 time = System.nanoTime()/1000000000 - startTime;
			//time = System.currentTimeMillis()/1000 - startTime;
			 
			     System.out.println("Zeit "+time);
			
			 
		 }
		
		 
	}
 
	
}
