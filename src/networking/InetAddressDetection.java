package networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDetection {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress names[] = InetAddress.getAllByName("techbinz.com");

        for(InetAddress name: names){
            System.out.println("Host Name              : " + name.getHostName());
            System.out.println("Host Address           : " + name.getHostAddress());
            System.out.println("Address                : " + getReadableAddress(name.getAddress()));
            System.out.println("LoopBack               : " + name.getLoopbackAddress());
            System.out.println("Canonical Host Name    : " + name.getCanonicalHostName());

            InetAddress address = InetAddress.getByName(name.getHostName());
            String value = address.isAnyLocalAddress() ? "YES" : "NO";
            System.out.println("Is local Address? " + value);
        }
    }

    // Método para convertir byte[] a una dirección IP legible
    public static String getReadableAddress(byte[] addressBytes) {
        StringBuilder ipString = new StringBuilder();
        for (byte b : addressBytes) {
            ipString.append(b & 0xFF).append(".");  // Convertir byte a entero sin signo y agregar "."
        }
        ipString.setLength(ipString.length() - 1); // Eliminar el último punto
        return ipString.toString();
    }
}
