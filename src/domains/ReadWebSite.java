package domains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ReadWebSite {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://ocsaly.com");
            URLConnection urlConnection = url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String myLine;
            while((myLine = br.readLine()) != null){
                System.out.println(myLine);
            }
            br.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
