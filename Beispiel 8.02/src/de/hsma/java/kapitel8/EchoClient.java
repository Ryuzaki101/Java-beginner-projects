package de.hsma.java.kapitel8;

import java.io.*;
import java.net.*;

/** 
 * Ein Client für einen Echo-Server, der auf den Port 7 hört
 */
public class EchoClient {
	
	public static void main(String[] args) throws IOException {
		
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			// Erzeugung eines Socket-Objektes, welches die Verbindung zum Server herstellt
			echoSocket = new Socket("141.19.96.200", 7);
			// Erzeugung von In- und Output-Streambuffern des Sockets
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Host unbekannt");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Verbindung zu Host konnte nicht hergestellt werden");
			System.exit(1);
		}

		// BufferedReader für die Standard-Eingabe erzeugen
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.println("Text eingeben der übertragen werden soll");
		System.out.println("(Die Eingabe von \"Ende\" beendet das Programm)");
		
		// Endlosschleife bis der Benutzer "Ende" eingibt
		while (!(userInput = stdIn.readLine()).equals("Ende")) {
			// Versand der eingegeben Zeile an den Echo-Server
			out.println(userInput);
			// Antwort des Echo-Servers ausgeben
			System.out.println("echo: " + in.readLine());
		} 
		
		// Schliessen der Reader und Writer sowie des Sockets
		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	}
}