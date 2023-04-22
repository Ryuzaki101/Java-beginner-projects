package de.hsma.java.kapitel7;

/** 
 * Produzent2, schreibt die Werte von -1 bis -25 
 */
public class Producer2 extends Thread {
	private Container container;

	public Producer2(Container c) {
		container = c;
	}

	public void run() {
		for (int i = -1; i >= -25; i--){
			try {
				container.put(i);
				System.out.println("Produzent2 schrieb " + i);
			} catch (ContainerException ce) {
				System.out.println("Produzent2: " + ce.getMessage());
				container.randomSleep();
			}
		}
	}
}