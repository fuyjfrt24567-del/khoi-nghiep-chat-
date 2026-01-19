import java.net.ServerSocket;
import java.net.Socket;
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9999);
        System.out.println("Connected to server");
    }
}
