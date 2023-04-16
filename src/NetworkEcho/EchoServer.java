package NetworkEcho;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings({"resource", "InfiniteLoopStatement"})
public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        while(true) {
            // Waiting for client.
            System.out.println("Waiting...");
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Can write Server-client stuff this way.
//            Client client = new Client(socket);
//            Thread thread = new Thread(client);
//            thread.start();

            // OR this way.
//            Thread thread = new Thread (new Client(socket));
//            thread.start();

            // OR this way.
            new Thread (new Client(socket)).start();
        }
    }
}
