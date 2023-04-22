package de.hsma.java.kapitel4;

import java.util.Vector;

public class VectorCollection {

	public static void main(String[] args) {

		// Collection zu Speicherung von Integer-Objekten
		Vector<Integer> numbers = new Vector<Integer>();

		// Neue Objekte hinzufügen
		numbers.add(new Integer(1));
		numbers.add(new Integer(10));
		numbers.add(100);
		numbers.add(new Integer(1000));

		int sum = 0;
		
		// Aufaddieren aller Werte der Collection 
		for (int i=0; i<numbers.size(); i++) 
			sum = sum + numbers.elementAt(i);	// Ohne Cast-Operation möglich, da Collection typgebunden ist
		
		// Summe der Werte ausgeben
		System.out.println("Summe: " + sum);

		// Alle Objekte löschen
		numbers.clear();  
	}
}
