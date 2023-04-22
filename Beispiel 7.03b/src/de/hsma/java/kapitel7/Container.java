package de.hsma.java.kapitel7;

/** 
 * Die Container-Klasse realisiert den Container in Form eines Ringspeichers. 
 * Sie verfügt über einen Array namens buffer zur Ablage von 10 int-Zahlen, 
 * die Umlaufzeiger head (lesen) und tail (schreiben) sowie eine Variable anz, 
 * welche die aktuelle Anzahl der im Behälter enthaltenen int-Zahlen zählt. 
 */					
class Container {
	private final int MAX = 10;
	private int head, tail, anz;
	private int buffer[];

	public Container() {
		head = tail = anz = 0;
		buffer = new int[MAX];
		
		for (int i=0; i<MAX; i++)
			buffer[i]=0;
	}	

	/**
	 * Schreiben eines Wertes in den Ringspeicher
	 */
	public synchronized void put(int value) throws ContainerException {
		if (anz == MAX)
			throw new ContainerException("Container voll beim Schreibversuch von " + value);
		else {
			buffer[tail] = value;
			randomSleep();			// Verzögerung des Aufrufs um Problem zu verdeutlichen
			tail = (tail+1) % MAX;
			anz++;
		}
	}		

	/**
	 * Lesen eines Wertes aus dem Ringspeicher
	 */
	public synchronized int get() throws ContainerException {
		if (anz == 0)
			throw new ContainerException("Container leer beim Leseversuch");
		else {
			int ret = buffer[head];
			randomSleep();			// Verzögerung des Aufrufs um Problem zu verdeutlichen
			head = (head + 1) % MAX;
			anz--;
			return ret;
		} 
	}

	void randomSleep() {
		try {     
			int rs = Math.round((float)Math.random());
			if (rs != 0)
				Thread.sleep(rs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}