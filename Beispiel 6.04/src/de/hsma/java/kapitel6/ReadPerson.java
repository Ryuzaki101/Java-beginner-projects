package de.hsma.java.kapitel6;

import java.io.*;

/**
 * Dieses Programm liest ein Objekt
 * vom Typ "Person" aus einer Datei mit
 * dem Namen "Person.ser"
 */
public class ReadPerson {

	public static void main(String[] args) {

		Person p = null;
		ObjectInputStream ois = null;

		try {
			// Inputstream öffnen
			ois = new ObjectInputStream(new FileInputStream("Person.ser"));

			// readObject() liefert eine Object-Referenz auf das deserialisierte Objekt zurück. 
			// Voraussetzung für die Deserialisierung ist die Existenz der .class-Datei des deserialisierten Objekttyps. 
			p = (Person) ois.readObject();

			System.out.println("Person gelesen: Name: " + p.name + ", Passwort: " + p.password);

		} catch (Exception e) {
			// Es werden alle Typen von Exceptions abgefangen, da
			// die Methode readObject() neben einer IO-Exception 
			// auch eine ClassNotFoundException werfen kann, falls die 
			// class-Datei der zu deserialisiernden Klasse nicht vorliegt.
			
			e.printStackTrace();
		} finally {
			if (ois != null ) {
				try { 
					ois.close(); 
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}	