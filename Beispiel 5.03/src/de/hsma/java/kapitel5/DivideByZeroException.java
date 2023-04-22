package de.hsma.java.kapitel5;

/** 
 * Benutzerdefinierte Exception 
 * 
 * Abgeleitet von Exception oder 
 * einer ihrer Unterklassen, in
 * diesem Fall von ArithmeticException.
 */
public class DivideByZeroException extends ArithmeticException {
	private int div;

	/** 
	 * Parameterloser Pflichtkonstruktor
	 */
	public DivideByZeroException() {
		super();
	}

	/** 
	 * Pflichtkonstruktor mit Fehlertext als Parameter
	 */
	public DivideByZeroException(String msg) {
		super(msg);
	}

	/** 
	 * Optionaler Konstruktor mit zusätzlichem Parameter, dem Dividenden
	 */
	public DivideByZeroException(String msg, int d) {
		super(msg);
		div = d;
	}
	
	/** 
	 * Zugriff auf den Dividenden
	 */
	public int getDiv() {
		return div;
	}
}