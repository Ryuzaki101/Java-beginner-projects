

/** Demonstriert die Erzeugung und den Zugriff auf Objekte */
public class GeoApp {
	
	public static void main (String[] args)  {
		
		MyPoint p1 = new MyPoint(100,200);  
		
		MyPoint p2 = null;
		p2 = new MyPoint(200,100);
		
		MyPoint p3 = new MyPoint();
		p3.moveTo(p1.x,p1.y); 
		
		System.out.println("Koordinaten von p1: [" + p1.x + "," + p1.y + "]");
		System.out.println("Koordinaten von p2: [" + p2.x + "," + p2.y + "]");
		System.out.println("Koordinaten von p3: [" + p3.x + "," + p3.y + "]");
	}
}



