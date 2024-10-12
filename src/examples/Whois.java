package examples;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Whois {
    public static void main(String[] args) {

        if(args.length < 1) {
            return;
        }

        String domainName = args[0];
        String hostname = "whois.internic.net";
        int port = 43;

        try(Socket socket = new Socket(hostname, port)){
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println(domainName);

            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (UnknownHostException e){
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
