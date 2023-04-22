
/** Geometrisches Rechteck */
class Rectangle extends Square {
	protected int height;		// Höhe des Rechtecks
								// Breite sowie Koordinaten werden von der Klasse Square geerbt

	public Rectangle(int x, int y, int w, int h) {
		super(x,y,w);
		height = h;
	}

	public void expand(int expandFactor) {
		super.expand(expandFactor);
		height = height * expandFactor;
	}

	public int area() {
		return width * height;
	}
}