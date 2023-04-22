package de.hsma.java.kapitel7;

/** Simuliert einen Würfel*/
public class Dice extends Thread {

									// wenn der Dice-Thread terminiert werden soll
	private int pip=0;  // Augenzahl des Würfels-1

	/**
	 * Thread enthält eine leere Methode namens run(), 
	 * welche in abgeleiteten Klassen überschrieben werden muss. 
	 * Sie enthält den vom Thread ausgeführten Programmcode. 
	 */
	public void run() {
		
		while(!this.isInterrupted()) {
			pip = (pip + 1) % 6;	// Zyklische Inkrementierung der Augenzahl
			
			//yield();  				// Übergebe Kontrolle an Haupt-Thread, 
									// sobald dieser Wartezeit beendet hat
		}
		
		// Ausgabe der zuletzt erreichten Augenzahl
		System.out.println("Gewürfelt: " + (pip+1));
	}
}