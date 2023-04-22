package de.hsma.java.kapitel4;

class OuterClass {
	private int x,y;
	public InnerClass inner;

	public OuterClass(int x, int y, int z) {
		this.x = x;
		this.y = y;
		inner = new InnerClass(z);		// Erzeugung der inneren Klasse
	}

	class InnerClass {
		private int z;

		public InnerClass(int z) {
			this.z = z;
		}

		public int calcVolume() {
			return x * y * z;		// Direkter Zugriff auf die privaten Elemente der OuterClass
		}
	}
}