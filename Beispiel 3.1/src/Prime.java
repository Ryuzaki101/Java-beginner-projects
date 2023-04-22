/**
 Berechnet alle Primzahlen bis 100
 */
public class Prime {

	public static void main(String[] args) {
		
		for (int i = 3; i <= 100; i++) {
			if(isPrime(i))
				System.out.println(i + " ist prim");
		}
	}

	public static boolean isPrime(int i) {
		
		for (int j = 2; j < i; j++) {
			if((i % j) == 0){
				return false;
			}
		}
		return true;
	}
}
