package de.hsma.java.kapitel7;

/** Simuliert einen W�rfel*/
public class Dice extends Thread {

									// wenn der Dice-Thread terminiert werden soll
	private int pip=0;  // Augenzahl des W�rfels-1

	/**
	 * Thread enth�lt eine leere Methode namens run(), 
	 * welche in abgeleiteten Klassen �berschrieben werden muss. 
	 * Sie enth�lt den vom Thread ausgef�hrten Programmcode. 
	 */
	public void run() {
		
		while(!this.isInterrupted()) {
			pip = (pip + 1) % 6;	// Zyklische Inkrementierung der Augenzahl
			
			//yield();  				// �bergebe Kontrolle an Haupt-Thread, 
									// sobald dieser Wartezeit beendet hat
		}
		
		// Ausgabe der zuletzt erreichten Augenzahl
		System.out.println("Gew�rfelt: " + (pip+1));
	}
}