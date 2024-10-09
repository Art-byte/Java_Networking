package networking;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class Network {

    public static void main(String[] args) {
        try{
            Enumeration<NetworkInterface> netwokInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            System.out.println("networking.Network Display: \n" );
            for(NetworkInterface element: Collections.list(netwokInterfaceEnumeration)){
                System.out.printf("%-8s %-32s \n", element.getName(), element.getDisplayName());
            }

        }catch (SocketException e){
            e.printStackTrace();
        }
    }
}
