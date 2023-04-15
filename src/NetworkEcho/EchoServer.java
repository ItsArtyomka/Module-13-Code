package NetworkEcho;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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

class Client implements Runnable {
    Socket socket;
    public Client(Socket socket){
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            Scanner in = new Scanner(is);
            PrintStream out = new PrintStream(os);

            out.println("Welcome to mountains!");
            String input = in.nextLine();
            while (!input.equals("bye")) {
                out.println(input + "-" + input + "-" +
                        input.substring(input.length() / 2) + "...");
                input = in.nextLine();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
