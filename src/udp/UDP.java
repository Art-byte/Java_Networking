package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP {

    public static void main(String[] args) throws IOException {

        //1.Create a Diagram Socket Object
        DatagramSocket datagramSocket = new DatagramSocket(2082);
        //2.Create a buffer for incoming diagrams
        byte[] buffer = new byte[256];
        //3.Crate DatagramPacket for the incoming datagrams
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        //4.Accept an incoming datagram
        datagramSocket.receive(datagramPacket);
        //5.Accept the sender address and port from the packet
        InetAddress clientAddress = datagramSocket.getInetAddress();
        //6.Retrieve the data from the buffer
        String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        //7.Create the response datagram
        DatagramPacket outPacket = new DatagramPacket(
                message.getBytes(),
                message.length(),
                clientAddress,
                datagramSocket.getPort());
        //8.Send the response datagram
        datagramSocket.send(outPacket);
        datagramSocket.close();
    }
}
