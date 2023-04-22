
/** Definiert ein Interface für geometrische Objekte */
public interface GeoObj {
	public MyPoint defaultPosition = new MyPoint(0,0);  // final static
	
	public void moveTo(int newX, int newY);
	public void expand(int expandFactor);
	public int area();
}
