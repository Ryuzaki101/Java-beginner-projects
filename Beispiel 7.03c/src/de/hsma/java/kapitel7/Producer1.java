package de.hsma.java.kapitel7;

/** 
 * Produzent1, schreibt die Werte von 1 bis 25 
 */
public class Producer1 extends Thread {
	private Container container;

	public Producer1(Container c) {
		container = c;
	}

	public void run() {
		for(int i = 1; i <= 25; i++){
			container.put(i);
			System.out.println("Produzent1 schrieb " + i);
		}
	}
}