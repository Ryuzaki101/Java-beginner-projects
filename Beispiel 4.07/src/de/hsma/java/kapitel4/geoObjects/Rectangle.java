package de.hsma.java.kapitel4.geoObjects; 

/** Geometry class Rectangle */
public class Rectangle extends Square {
	protected int height;

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

	public String toString() {
		return new String("Rectangle (" + p.x + " " + p.y +	" " + width + " " + height +")");
	}
}


