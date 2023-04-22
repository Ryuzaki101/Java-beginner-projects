package de.hsma.java.kapitel6;

import java.io.*;

/** 
 * Die Klasse "Person" stellt eine serialisierbare Klasse dar.
 * Bevor das Passwort serialisiert wird, wird es chiffriert.
 * 
 * Beim deserialisieren wird das Passwort wieder entsprechend
 * dechiffriert.
 * 
 * Der hier genutzte Chiffrier-Algorithmus ist allerdings 
 * nicht sicher und w�rde einem ernst gemeinten Angriff nicht
 * standhalten k�nnen...
 */
public class Person implements Serializable {
	
	private static final long serialVersionUID = 762347623429L;
	
	public String name;
	public String password;

	public Person (String name, String password) {
		this.name = name;
		this.password = password;
	}

	/**
	 * Bei Vorhandensein dieser Methode wird die 
	 * Standard-Serialisierung au�er Kraft gesetzt 
	 * und statt dessen diese Methode aufgerufen.
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException    {
		password = crypt(password, 111);
		System.out.println("Passwort verschl�sselt zu " + password);
		
		// Aufruf der Standard-Serialisierung
		oos.defaultWriteObject();
		
		password = crypt(password, 111);
	}

	/**
	 * Bei Vorhandensein dieser Methode wird die 
	 * Standard-Deserialisierung au�er Kraft gesetzt 
	 * und statt dessen diese Methode aufgerufen.
	 */
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		// Aufruf der Standard-Deserialisierung
		ois.defaultReadObject();
		
		password = crypt(password, 111);
		System.out.println("Passwort entschl�sselt zu " + password);
	}
	
	static String crypt(String input, int key){
		
		StringBuffer sb = new StringBuffer();
		
		for (int i=0; i<input.length(); i++)
			// Der Chiffrier-Algorithmus f�hrt eine Exklusiv-Oder-Verkn�pfung 
			// aller Zeichen eines Strings  mit einem ganzzahligen Schl�ssel durch.
			sb.append((char) (key ^ input.charAt(i)));
		
		return sb.toString();
	}
}