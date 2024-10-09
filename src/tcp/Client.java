package tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private static InetAddress HOST;
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try{
            HOST = InetAddress.getLocalHost();

        }catch (UnknownHostException e){
            System.out.println("ERROR CAUSED: " + e.getMessage());
            System.exit(1);
        }
        accessServer();
    }

    private static void accessServer(){
        Socket link = new Socket();
        try{
            link = new Socket(HOST, PORT);
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter ouput = new PrintWriter(link.getOutputStream(), true);
            Scanner userEntry = new Scanner(System.in);
            String message, response;

            do{
                System.out.println("ENTER MESSAGE: ");
                message = userEntry.nextLine();
                ouput.println(message);
                response = input.nextLine();
                System.out.println("\nSERVER > " + response);

            } while(!message.equals("***CLOSE***"));

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                System.out.println("\n CLOSING CONNECTION");
                link.close();
            } catch (IOException e) {
                System.out.println("Unable to Disconnect " + e.getMessage());
                System.exit(1);
            }
        }
    }
}
