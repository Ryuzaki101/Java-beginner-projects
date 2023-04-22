
/**
 * Demonstriert den Umgang mit Strings
 */
public class SearchName {

	public static void main(String[] args) {
		
		String list[] = {"Tim", "Frank", "Dennis"};
		
		if(args.length != 1){
			System.out.println("Aufruf: java searchName <name>");
			return; 	// oder System.exit(1);
		}
		
		for (int i = 0; i < list.length; i++) {
			if(list[i].equals(args[0])){
				System.out.println(args[0] + " gefunden an Position " + i);
				return;
			}
		}
		System.out.println(args[0] + " nicht gefunden");
	}
}
