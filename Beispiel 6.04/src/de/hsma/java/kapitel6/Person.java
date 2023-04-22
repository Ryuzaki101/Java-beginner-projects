package de.hsma.java.kapitel6;

import java.io.*;

/**
 * Die Klasse "Person" realisiert
 * eine serialisierbare Klasse.
 */
public class Person implements Serializable {
	// Das Interface Serializable dient lediglich 
	// zur Kennzeichnung der Serialisierbarkeit der Klasse.
	
	// Versionsnummer der Klasse. Falls nicht explizit angebeben wird sie automtatisch berechnet.
	// Bei der Deserialiserung wird eine InvalidClassException geworfen, 
	// wenn die abgespeicherte Versionsnummer nicht mit der Versionsnummer 
	// in der vorliegenden .class-Datei übereinstimmt. 
	private static final long serialVersionUID = 3;
	
	public String name;
	public String password;

	public Person (String name, String password) {
		this.name = name;
		this.password = password;
	}
}








