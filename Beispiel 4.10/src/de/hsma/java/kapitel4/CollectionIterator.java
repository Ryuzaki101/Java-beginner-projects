package de.hsma.java.kapitel4;

import java.util.Vector;
import java.util.Iterator;

public class CollectionIterator {

	public static void main(String[] args) {

		// Collection zu Speicherung von Integer-Objekten
		Vector<Integer> numbers = new Vector<Integer>();

		// Neue Objekte hinzufügen
		numbers.add(new Integer(1));
		numbers.add(new Integer(10));
		numbers.add(100);
		numbers.add(1000);

		int sum = 0;

		Iterator<Integer> it = numbers.iterator();	// Erzeugung eines Iterators
		while (it.hasNext())
			sum = sum + it.next();		// Ohne Cast-Operation möglich, da auch Iterator typgebunden ist
		
//		for (Integer num : numbers) {
//			sum = sum + num;
//		}
		
		// Summe der Werte ausgeben
		System.out.println("Summe: " + sum);

		// Alle Objekte löschen
		numbers.clear();  
	}
}