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

		// Erzeugung einer Instanz der Klasse Dice
		Dice dice = new Dice();
		
		// Erstellen eines Threads mit dem Runnable Dice
		Thread diceThread = new Thread(dice);
		
		// Starten des Threads, welcher die run()-Methode der Runnable-Klasse Dice ausf�hrt.
		diceThread.start();

		try {
			Thread.sleep((int)(Math.random()*1000));
			dice.runFlag = false;
			diceThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}