package networking;

import java.net.URI;
import java.net.URISyntaxException;

public class UriDirection {
    public static void main(String[] args) throws URISyntaxException {
        String website = "https://techbinz.com/ecu-ecm-power-management/";
        URI uri = new URI(website);
        getURI(uri);
    }

    static void getURI(URI myURI){
        System.out.println("Authority    : " + myURI.getAuthority());
        System.out.println("Path         : " + myURI.getPath());
        System.out.println("Host         : " + myURI.getHost());
        System.out.println("Port         : " + myURI.getPort());
        System.out.println("Scheme       : " + myURI.getScheme());
        System.out.println("User Info    : " + myURI.getUserInfo());
        System.out.println("Fragment     : " + myURI.getFragment());
        System.out.println("Query        : " + myURI.getQuery());
    }
}
