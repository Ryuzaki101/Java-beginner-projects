package de.hsma.java.kapitel7;

/** Simuliert einen Würfel*/
public class Dice implements Runnable {

	public boolean runFlag = true;
	private int pip=0; 

	public void run() {
		while(runFlag) {
			pip = (pip +1 ) % 6;
			Thread.yield(); // yield() muss in diesem Falle über einen qualifizierten Namen aufgerufen werden.
		}
		System.out.println("Gewürfelt: " + (pip+1));
	}
}