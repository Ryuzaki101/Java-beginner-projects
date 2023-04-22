package de.hsma.java.kapitel7;
			
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
	public synchronized void put(int value) {

		// Bei vollem Container wird der Producer-Thread blockiert, 
		// bis er durch eine notify()-Operation vom dem Consumer-Thread geweckt wird.
		while(anz == MAX){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		buffer[tail] = value;
		randomSleep();			
		tail = (tail+1) % MAX;
		anz++;
		notify();
	}		

	/**
	 * Lesen eines Wertes aus dem Ringspeicher
	 */
	public synchronized int get() {

		// Bei leerem Container wird der Consumer-Thread blockiert, 
		// bis er durch eine notify()-Operation von einem Producer-Thread geweckt wird.
		while(anz == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int ret = buffer[head];
		randomSleep();
		head = (head + 1) % MAX;
		anz--;
		notify();
		return ret;
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