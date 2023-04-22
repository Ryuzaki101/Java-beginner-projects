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

			// Person laden
			p = (Person)ois.readObject();

			System.out.println("Person gelesen: Name: " + p.name + ", Passwort: " + p.password);

		} catch (Exception e) {
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


