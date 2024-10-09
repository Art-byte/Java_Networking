package tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static ServerSocket serverSocket;
    private static final int PORT = 1234;

    public static void main(String[] args) {
        System.out.println("Opening port... " + PORT + "\n");
        try{
            serverSocket = new ServerSocket(PORT);
        }catch (IOException e){
            System.out.println("Unable attach to port!");
            System.exit(1);
        }

        do{
            handleClient();
        }while (true);
    }

    private static void handleClient(){
        Socket link = null;
        try{
            link = serverSocket.accept(); //Aceptamos la conexion
            Scanner input = new Scanner(link.getInputStream()); //Escuchamos los datos de entrada
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);
            int numMessages = 0;
            String message = input.nextLine();
            while(!message.equals("***CLOSE***")){
                System.out.println("Message received :" + message);
                numMessages++;
                output.println("MESSAGE " + numMessages + ": " + message);
                message = input.nextLine();
            }
            output.println(numMessages + "MESSAGES RECEIVED");

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                System.out.println("\n************ CLOSING CONNECTION... ************");
                link.close();
            } catch (IOException e){
                System.out.println("**** UNABLE TO DISCONNECT! ****");
                System.exit(1);
            }
        }
    }
}
