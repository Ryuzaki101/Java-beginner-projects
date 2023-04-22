
/** Polymorphie am Beispiel */
public class GeoApp {

	public static void main(String args[]) {

		GeoObj v[] = new GeoObj[3];

		// array mit verschiedenen Objekttypen f�llen
		v[0] = new Square();
		v[1] = new Square(100, 60, 40);
		v[2] = new Rectangle(80, 50, 80, 60);

		// Berechne die Fl�che aller Objekte im array, welche eine Fl�che darstellen
		int ar = 0;
		for (int i = 0; i < v.length; i++) {

			GeoObj gObj = v[i]; 	
			ar = ar + gObj.area();	// Polymorphie

		}

		System.out.println("Gesamtfl�che: " + ar);
	}
}
