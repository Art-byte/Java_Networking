package networking;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDetection {
    public static void main(String[] args) throws MalformedURLException {
        String web = "https://en.wikipedia.org/wiki/URL#Citations";
        URL url = new URL(web);
        getURL(url);
    }

    static void getURL(URL url){
        System.out.println("Authority     : " + url.getAuthority());
        System.out.println("Host          : " + url.getHost());
        System.out.println("Ref           : " + url.getRef());
        System.out.println("Path          : " + url.getPath());
        System.out.println("Port          : " + url.getPort());
        System.out.println("Default Port  : " + url.getDefaultPort());
        System.out.println("File          : " + url.getFile());
        System.out.println("Protocol      : " + url.getProtocol());
        System.out.println("User Info     : " + url.getUserInfo());
    }
}
