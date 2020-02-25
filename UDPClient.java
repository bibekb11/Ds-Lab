import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String args[]) {
        DatagramSocket clientSocket = null;
        Scanner scanner = new Scanner(System.in);
        byte clientBuffer[] = null;
        byte[] receiveserverMessage = new byte[1000];
        DatagramPacket serverMessagepacket = null;

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            clientSocket = new DatagramSocket();

            while (true) {
                String clientMessage = scanner.nextLine(); // get string or message from the client to send to server
                clientBuffer = clientMessage.getBytes(); // changing string to buffer
                DatagramPacket clientPackets = new DatagramPacket(clientBuffer, clientBuffer.length, inetAddress, 3000);
                clientSocket.send(clientPackets);
                // receive server message
                serverMessagepacket = new DatagramPacket(receiveserverMessage, receiveserverMessage.length);
                clientSocket.receive(serverMessagepacket);
                System.out.println("Server : " + new String(receiveserverMessage));
                receiveserverMessage = new byte[1000];

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
