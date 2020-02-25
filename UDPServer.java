import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPServer {
    public static void main(String args[]) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(3000);
            byte[] receiveclientMessage = new byte[1000]; // buffer to store client message
            byte[] serverBuffer = null;
            DatagramPacket serverPackets = null;
            System.out.println("Server is waiting......");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                serverPackets = new DatagramPacket(receiveclientMessage, receiveclientMessage.length);
                serverSocket.receive(serverPackets);
                System.out.println("Client : " + new String(receiveclientMessage));
                receiveclientMessage = new byte[1000];
                String serverMessage = scanner.nextLine();
                serverBuffer = serverMessage.getBytes();
                InetAddress cliInetAddress = serverPackets.getAddress();
                int clientPort = serverPackets.getPort();
                DatagramPacket serverSendPacket = new DatagramPacket(serverBuffer, serverBuffer.length, cliInetAddress,
                        clientPort);
                serverSocket.send(serverSendPacket);

            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
