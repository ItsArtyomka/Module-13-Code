package Exercise13_3_3.ChatApp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

@SuppressWarnings({"InfiniteLoopStatement"})
// Class used to create a server for the chat clients.
public class ChatServer {
    // Creating an array of clients.
    ArrayList<ChatClient> clients = new ArrayList<>();
    ServerSocket serverSocket;

    ChatServer() throws IOException {
        // Creating a server socket with port 1234.
        serverSocket = new ServerSocket(1234);
    }

    // Sending a message to all the clients.
    void sendAll(String message) {
        for (ChatClient chatClient : clients){
            chatClient.receive(message);
        }
    }

    public void run() {
        while (true) {
            System.out.println("Waiting for client...");
            // Waiting for client.
            try { // try runs IF new client is connected.
                // Accepting new client.
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Creating a chat client and adding it to the array.
                clients.add(new ChatClient(socket, this));

            } catch (IOException ex) { // IF no clients were connected
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Creating a ChatServer object to run the server using run().
        new ChatServer().run();
    }
}
