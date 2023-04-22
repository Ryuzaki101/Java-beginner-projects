package de.hsma.java.kapitel4;

/** Demonstriert den Umgang mit inneren Klassen */
public class InnerClassDemo { 
	
	public static void main(String[] args) {
		
		OuterClass outer = new OuterClass(2,2,2);
		
		System.out.println("Volumen: " + outer.inner.calcVolume());
	} 
}