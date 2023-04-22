package de.hsma.java.kapitel7;

/** 
 * Das Programm startet einen Würfel.
 * Der Würfel zählt zyklisch von 1 bis 6, so lange das "run flag"
 * gesetzt ist.
 * 
 * Das Hauptprogramm wartet eine zufällige Zeit ab, bevor das "run flag"
 * zurückgesetzt wird und somit eine Ausgabe erfolgt.
 * 
 * Damit das Hauptprogramm die Kontrolle so schnell wie möglich 
 * zurückerhalten kann, ruft der Würfel wiederholt die yield()-Methode auf.
 */	  	  
public class ThrowDice {
	
	public static void main (String[] args)  {
		
		Dice dice = new Dice();
		dice.start();			// Starten des Würfel-Threads
		
		try {
			Thread.sleep((int)(Math.random()*1000));	// Haupt-Thread legt sich eine zufällige Zeit (zwischen 0s und 1s) schlafen
														// Aufgrund der vom Dice-Thread zyklisch durchgeführten yield()-Operation 
			dice.interrupt();					// erhält der Haupt-Thread unmittelbar nach der Wartezeit die Kontrolle zurück. 
			
//			dice.join();  								// Warten auf Beendigung des würfelns
		} catch (InterruptedException e) {
		}
	}
}