/*
 * 
 * Sujan Vamathevan
 * MatrNr: 1220859
 * 
 */

package SS15;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
	static List<Socket> allSocks = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		boolean listening = true;
		try {
			serverSocket = new ServerSocket(8888);
		} catch (IOException e) {
			System.err.println("Kann nicht auf Port 888 hören");
			System.exit(1);
		}
		while (listening) {
			Socket clientSocket = null;
			try {
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.err.println("Accept fehlgeschlagen");
				System.exit(1);
			}
			allSocks.add(clientSocket);
			new CommunicationThread(clientSocket).start();
		}
	}
}

class CommunicationThread extends Thread {
	private Socket cs;
	public CommunicationThread(Socket cS) {
		cs = cS;
	}

	public void run() {
		PrintWriter out = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Message form:"+ cs.getInetAddress() +": "+inputLine);
				for(Socket tmpSock : ChatServer.allSocks) {
					out = new PrintWriter(tmpSock.getOutputStream(), true);
					out.println(tmpSock.getInetAddress()+": "+inputLine);
				}
			}
			out.close();
			in.close();
			cs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
