

/** Dummy Klasse */
class Dummy {  
	public static int created = 0, finalized = 0;	// Zähler für erzeugte bzw. finalisierte Objekte
	public static boolean createFlag = true;		// Gibt an ob weitere Objekte erzeugt werden sollen	
	public int no;									// Fortlaufende Instanznummer

	public Dummy() {
		created++;									// Zähler für erzeugte Objekte inkrementieren
		this.no = created;							// Instanznummer zuweisen

		System.gc();            					// Den Garbage Collector explizit aufrufen
	}

	protected void finalize() {
		if (finalized == 0)    						// Beim ersten Aufruf dieser Methode durch den Garbage Collector
			createFlag = false;  					// soll die Erzeugung weiterer Objekte unterbunden werden

		finalized++; 								// Zähler für finalisierte Objekte inkrementieren
	}
}