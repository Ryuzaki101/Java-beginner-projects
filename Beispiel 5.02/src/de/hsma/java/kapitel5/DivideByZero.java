package de.hsma.java.kapitel5;

/** 
 * Demonstriert die Weiterleitung von Exceptions
 */
public class DivideByZero {
	
	public static void main(String[] args) {
	
		int erg=0;

		for (int i=-2; i<=2; i++) {
			try { 
				erg = divide(10,i);
				System.out.println("10/" + i + " = " + erg);

			} catch(ArithmeticException e) {
				// Die Exception muss von der aufrufenden
				// Methode behandelt oder ebenfalls mittels throws
				// weitergegeben werden 
				System.out.println("Exception: " + e.getMessage());
			}
		}
	}

	public static int divide(int a, int b) throws ArithmeticException {
		// Bei der Division eventuell auftretende Exception
		// wird nicht behandelt, sondern an die aufrufende
		// Methode mittels throws hochgereicht.
		
		return a/b;
	}
}
