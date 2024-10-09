package tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketDefinition {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1092);
        Socket link = serverSocket.accept();

        Scanner input = new Scanner(link.getInputStream());
        PrintWriter ouput = new PrintWriter(link.getOutputStream());

        ouput.println("awaiting for data...");
        String input1 = input.nextLine();

        link.close();
    }
}
