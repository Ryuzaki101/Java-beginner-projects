package de.hsma.java.kapitel8;
//Author. Othman B.
//Echo Client
import java.io.*;
import java.net.*;

public class EchoClient {
	public static void main(String[] args) throws IOException {
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			echoSocket = new Socket("localhost", 443);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Host unknown");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Connexion to Host failed");
			System.exit(1);
		}
		BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in) );
		String userInput;
		System.out.print("Input Text to be transmitted");
		System.out.println("(The Input \"Exit\" closes the program)");
		while (!(userInput = stdIn.readLine()).equals("Exit")) {
			out.println(userInput);
			System.out.println("echo: " + in.readLine());
		}
		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	}
}