
/**
 * Demonstriert die Benutzung von Arrays 
 */
public class IntArray {

	public static void main(String[] args) {
		
		int feld[] = {0,1,2,3};
		System.out.println(max(feld));
	}
	private static int max(int[] feld) {
		int max = feld[0];
		
		for (int i = 1; i < feld.length; i++) {
			if(feld[i] > max){
				max = feld[i];
			}
		}
		return max;
	}
}
