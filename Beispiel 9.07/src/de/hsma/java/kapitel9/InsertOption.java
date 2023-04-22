package de.hsma.java.kapitel9;

/**
 * Enum f�r den Einf�gemodus
 */
public enum InsertOption {
	append("Hinzuf�gen"), insert("�berschreiben");

	String name;

	private InsertOption(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
