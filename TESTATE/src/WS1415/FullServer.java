package WS1415;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FullServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(3333);
			while (true) {
				Socket clientSocket = null;
				clientSocket = serverSocket.accept();

				new CommunicationThread(clientSocket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class CommunicationThread extends Thread {
	private Socket cs;
	private static int accDiagr = 0, accTime = 0, accFail = 0;

	public CommunicationThread(Socket cS) {
		cs = cS;
	}

	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			ObjectOutputStream oos = new ObjectOutputStream(cs.getOutputStream());
			String input;
			while ((input = in.readLine()) != null) {
				Date time = new Date();
				switch (input) {
					case "zeitstempel": {
						accTime++;
						oos.writeObject((new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss")).format(time));
					} break;
					case "diagramm": {
						accDiagr++;
						int chart[] = { accDiagr, accTime, accFail };
						oos.writeObject(chart);
					} break;
					default: {
						accFail++;
						oos.writeObject(null);
					}
				}
			}
			oos.flush();
			oos.close();
			in.close();
			cs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
