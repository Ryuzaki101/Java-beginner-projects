
/** Geometrische Operationen */
public class GeoApp {
	
	public static void main (String[] args)  {
		
		Square s = new Square(100, 100, 10);  

		s.moveTo(200,200);
		s.expand(2);
		
		System.out.println("Fläche: " + s.area());
	}
}

