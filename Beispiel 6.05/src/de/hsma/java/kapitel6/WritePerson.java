package de.hsma.java.kapitel6;

import java.io.*;

/**
 * Dieses Programm schreibt ein Objekt
 * vom Typ "Person" in eine Datei mit
 * dem Namen "Person.ser"
 */
public class WritePerson {

	public static void main(String[] args) {

		Person p = new Person("Mr. Bean", "forgotten");		// Person erzeugen 

		ObjectOutputStream oos = null;

		try {
			// Outputstream öffnen
			oos = new ObjectOutputStream(new FileOutputStream("Person.ser"));
			
			// Objekt speichern
			oos.writeObject(p);

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (oos != null) {
				try { 
					oos.close(); 
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}