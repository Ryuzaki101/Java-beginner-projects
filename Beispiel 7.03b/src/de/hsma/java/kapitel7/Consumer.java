package de.hsma.java.kapitel7;

/** 
 * Konsument versucht 50 mal Werte aus dem Container zu lesen
 */
public class Consumer extends Thread {
	private Container container;

	public Consumer(Container c) {
		container = c;
	}

	public void run() {

		int value = 0;

		for (int i = 1; i <= 50; i++){ 
			try {
				value = container.get();
				System.out.println("Konsument las " + value);
			} catch (ContainerException ce) {
				System.out.println("Konsument: " + ce.getMessage());
				container.randomSleep();	  
			}
		}
	}
}