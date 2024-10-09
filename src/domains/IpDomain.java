package domains;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpDomain {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress ipAddress = InetAddress.getByName("www.ocsaly.com");
        System.out.println("HOST ADDRESS          : " + ipAddress.getHostAddress());
        System.out.println("CANONICAL HOST NAME   : " + ipAddress.getCanonicalHostName());
        System.out.println("HOST NAME             : " + ipAddress.getHostName());


    }
}