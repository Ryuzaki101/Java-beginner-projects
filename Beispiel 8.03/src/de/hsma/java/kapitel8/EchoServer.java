package de.hsma.java.kapitel8;

//Author. Othman B.
//Echo Server
import java.io.*;
import java.net.*;

public class EchoServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		boolean listening = true;
		try {
			serverSocket = new ServerSocket(443);
		} catch (IOException e) {
			System.err.println("No listen on Porrt 9999");
			System.exit(1);
		}
		while (listening) {
			Socket clientSocket = null;
			try {
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.err.println("Accept failure");
				System.exit(1);
			}
			
			new  CommunicationThread(clientSocket).start();
		}
	}
	
}

class  CommunicationThread extends Thread {
		private Socket cs;
		public  CommunicationThread(Socket cS) {
			 cs = cS;
		}

		public void run() {
			PrintWriter out;
			try {
				out = new PrintWriter(cs.getOutputStream(),true);
				BufferedReader in = new BufferedReader(	new InputStreamReader( cs.getInputStream() ) );
				String inputLine;
			// Return Echo until client closes connexion 
				while ((inputLine = in.readLine()) != null)
					if(inputLine.contains("Exit") || inputLine.contains("exit")){
						out.println("You sure you want to leave if yes just typ Exit" + " => server answer");
					}else{
						out.println(inputLine + " => server answer");
					}
				out.close();
				in.close();
				cs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
}


