

public class Finalization {

	public static void main (String[] args)  {

		/*
		 * Fortlaufend Dummy-Objekte erzeugen, 
		 * welche nicht referenziert werden
		 * bis createFlag durch ersten Durchlauf 
		 * des Garbage Collectors auf false gesetzt wird.
		 */
		while (Dummy.createFlag)
			new Dummy();

		// Anzahl der erzeugten und finalisierten Objekte ausgeben
		System.out.println("Erzeugte Objekte:  " + Dummy.created);
		System.out.println("Finalisierte Objekte: " + Dummy.finalized);	
	}
}

