import java.io.*;
import java.net.*;
public class TCPServer {
	public static void main(String[]args) throws Exception{
	String clientData;
	String processedData;
	ServerSocket welcomeSocket=new ServerSocket(2222);
	System.out.println("Waiting for client");
	while(true) {
		Socket connectionSocket = welcomeSocket.accept();
		BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());
		clientData=inFromClient.readLine();
		System.out.println("FROM CLIENT"+clientData);
		processedData="ACK for"+clientData+"\n";
		outToClient.writeBytes(processedData);
	}
	}
}
