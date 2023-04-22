package de.hsma.java.kapitel5;

/** 
 * Demonstriert den Umgang mit 
 * benutzerdefinierten Exceptions 
 */
public class DivideByZero {
	public static void main (String[] args)  {
		int erg=0;

		for (int i=-2; i<=2; i++) {
			try { 
				erg = divide(10,i);
				System.out.println("10/" + i + " = " + erg);

			} catch(DivideByZeroException e) {
				// Die Behandlung einer Exception ist immer identisch
				// Bei dieser Exception kann allerdings zusätzlich noch der Dividend ausgelesen werden.
				// Die Methode getMessage() liefert den bei der Konstruktion der Exception angegebenen Fehlertext.
				System.out.println("Exception: " + e.getDiv() + e.getMessage());
			}
		}
	}

	public static int divide(int a, int b) throws DivideByZeroException {
		if (b == 0)
			// Benutzerdefiniete Exceptions müssen vom Programmierer ausgelöst werden.
			throw new DivideByZeroException(" dividiert durch 0", a);
		else
			return a/b;
	}
}