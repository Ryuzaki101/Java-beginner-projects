package de.hsma.java.kapitel4;

import de.hsma.java.kapitel4.geoObjects.MyPoint;
import de.hsma.java.kapitel4.geoObjects.Rectangle;
import de.hsma.java.kapitel4.geoObjects.Square;


/** Demonstriert den Umgang mit packages */
public class GeoApp {

	public static void main (String args[]) {

		Object v[] = new Object[3];

		// array mit verschiedenen Objekttypen füllen
		v[0] = new MyPoint(120, 80);
		v[1] = new Square(100, 60, 40);
		v[2] = new Rectangle(80, 50, 80, 60);  

		// Alle Objekte des arrays ausgeben
		for (int i=0; i< v.length; i++) 
			System.out.println(v[i].toString());   		// Polymorphie

		// Berechne die Fläche aller Objekte im array, welche eine Fläche darstellen
		int ar = 0;
		for (int i=0; i< v.length; i++) {

			Object obj = v[i];

			if (obj instanceof Square)
				ar = ar + ((Square)obj).area();	// Downcast
		}

		System.out.println("Gesamtfläche: " + ar);
	}
}
