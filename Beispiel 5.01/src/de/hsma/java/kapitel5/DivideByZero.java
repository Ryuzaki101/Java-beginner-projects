package de.hsma.java.kapitel5;

/** 
 * Demonstriert den Umgang mit Exceptions
 * 
 * Bei einer Nulldivision von int-Zahlen
 * wird eine "ArithmeticException" ausgelöst
 * und vom Programm abgefangen.
 * 
 */
public class DivideByZero{
	public static void main (String[] args)  {
		int erg=0;
		
		for (int i=-2; i<=2; i++) {
			
			try { 
				erg = 10/i;
				System.out.println("10/" + i + " = " + erg);
			
			} catch(ArithmeticException e) {
				// Unterbrechung der Schleife bei Nulldivision
				System.out.println("Exception: " + e.getMessage());
				// Anschliessend Fortsetzung der Schleife mit dem nächsten Wert
			}
		}
	}
}
