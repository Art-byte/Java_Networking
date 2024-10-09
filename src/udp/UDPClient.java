package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    private static InetAddress HOST;
    private static final int PORT = 2082;
    private static DatagramSocket datagramSocket;
    private static DatagramPacket inPacket, outPacket;
    private static byte[] buffer;

    public static void main(String[] args) {
        try{
            HOST = InetAddress.getLocalHost();
        }catch (UnknownHostException e){
            System.out.println("ERROR : " + e.getMessage());
            System.exit(1);
        }
        accessServer();
    }

    private static void accessServer(){
        try{
            datagramSocket = new DatagramSocket();
            Scanner userEntry = new Scanner(System.in);
            String message = "", response = "";
            do{
                System.out.println("Enter Message: ");
                message = userEntry.nextLine();
                if(!message.equals("***CLOSE***")){
                    outPacket = new DatagramPacket(message.getBytes(), message.length(), HOST, PORT);
                    datagramSocket.send(outPacket);
                    buffer = new byte[256];
                    inPacket = new DatagramPacket(buffer, buffer.length);
                    datagramSocket.receive(inPacket);
                    response = new String(inPacket.getData(), 0, inPacket.getLength());
                    System.out.println("\n SERVER RESPONSE > " + response);
                }
            }while (!message.equals("***CLOSE***"));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            System.out.println("\n Closing connection...");
            datagramSocket.close();
        }
    }

}
