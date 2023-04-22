
/** Geometrische Operationen */
public class GeoApp {
	
	public static void main (String[] args)  {
		
		Rectangle r = new Rectangle(100, 100, 10, 15);  

		r.moveTo(200,200);
		r.expand(2);
		
		System.out.println("Fläche: " + r.area());
	}
}

