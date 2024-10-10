import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientSide {
    public static void main(String[] args) {
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 5000);
        try(SocketChannel socketChannel = SocketChannel.open()){

            ByteBuffer byteBuffer = ByteBuffer.allocate(64);
            int byteRead = socketChannel.read(byteBuffer);
            while(byteRead > 0){
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()){
                    System.out.println((char) byteBuffer.get() + "\n");
                }
                System.out.println("\n");
                byteRead = socketChannel.read(byteBuffer);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
