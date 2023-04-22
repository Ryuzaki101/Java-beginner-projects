

/** Geometrischer Punkt */
class MyPoint {
	public int x, y;  

	public MyPoint() {
		this(0,0);
	}

	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void moveTo(int newX, int newY) {
		x = newX;
		y = newY;
	}
}