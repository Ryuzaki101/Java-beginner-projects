package de.hsma.java.kapitel7;

/**
 * Zwei Produzenten-Threads schreiben die Zahlen
 * 1 bis 25 bzw. -1 bis -25 in einen FIFO-
 * Container mit der Kapazität 10.
 * Ein Konsument versucht gleichzeitig,
 * alle Werte auszulesen.
 * 
 * Dies geschieht vollkommen unsynchronisiert.
 */
public class ProducerConsumer {
	
	public static void main(String[] args) {
		
		// Erzeugung der benötigten Objekte
		Container c = new Container();
		Producer1 prod1 = new Producer1(c);
		Producer2 prod2 = new Producer2(c);
		Consumer cons = new Consumer(c);

		// starten aller Threads
		prod1.start(); 
		prod2.start();
		cons.start();
	}
}
