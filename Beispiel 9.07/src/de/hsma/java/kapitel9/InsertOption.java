package de.hsma.java.kapitel9;

/**
 * Enum für den Einfügemodus
 */
public enum InsertOption {
	append("Hinzufügen"), insert("Überschreiben");

	String name;

	private InsertOption(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
