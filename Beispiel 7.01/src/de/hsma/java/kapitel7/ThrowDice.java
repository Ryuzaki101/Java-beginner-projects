package de.hsma.java.kapitel7;

/** 
 * Das Programm startet einen W�rfel.
 * Der W�rfel z�hlt zyklisch von 1 bis 6, so lange das "run flag"
 * gesetzt ist.
 * 
 * Das Hauptprogramm wartet eine zuf�llige Zeit ab, bevor das "run flag"
 * zur�ckgesetzt wird und somit eine Ausgabe erfolgt.
 * 
 * Damit das Hauptprogramm die Kontrolle so schnell wie m�glich 
 * zur�ckerhalten kann, ruft der W�rfel wiederholt die yield()-Methode auf.
 */	  	  
public class ThrowDice {
	
	public static void main (String[] args)  {
		
		Dice dice = new Dice();
		dice.start();			// Starten des W�rfel-Threads
		
		try {
			Thread.sleep((int)(Math.random()*1000));	// Haupt-Thread legt sich eine zuf�llige Zeit (zwischen 0s und 1s) schlafen
														// Aufgrund der vom Dice-Thread zyklisch durchgef�hrten yield()-Operation 
			dice.interrupt();					// erh�lt der Haupt-Thread unmittelbar nach der Wartezeit die Kontrolle zur�ck. 
			
//			dice.join();  								// Warten auf Beendigung des w�rfelns
		} catch (InterruptedException e) {
		}
	}
}