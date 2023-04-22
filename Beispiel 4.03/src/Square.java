
/** Geometrisches Quadrat */
class Square {
	protected MyPoint p;	// Element vom Verweistyp
	protected int width;

	public Square(int x, int y, int w) {
		p = new MyPoint(x,y);		// Instanziierung und Initialisierung des Elements p
		width = w;
	}

	public void moveTo(int newX, int newY) {
		p.moveTo(newX,newY);
	}

	public void expand(int expandFactor) {
		width = width * expandFactor;
	}

	public int area() {
		return width * width;
	}
}